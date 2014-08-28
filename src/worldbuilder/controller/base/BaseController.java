package worldbuilder.controller.base;

import java.util.ArrayList;
import java.util.List;

import worldbuilder.controller.base.validators.BaseValidator;
import worldbuilder.model.base.BaseObject;
import worldbuilder.util.UIUtil;
import worldbuilder.view.base.BaseView;

/**
 * This class contains fields and methods common to all controllers.
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The model object type
 * @param <ViewType> The view type
 */

public abstract class BaseController<ObjectType extends BaseObject, ViewType extends BaseView<?>> implements IController<ObjectType, ViewType> {

    /**
     * The object validator
     */

    protected BaseValidator<ObjectType> validator;

    /**
     * The view reference
     */

    protected ViewType view;

    /**
     * The list of objects
     */

    protected List<ObjectType> objects;

    /**
     * Constructor
     *
     * @param view The view reference
     */

    public BaseController(ViewType view) {
        this.view = view;
        this.objects = new ArrayList<ObjectType>();

        this.initValidator();
        this.initAdapters();
        this.setUpControls();
    }

    @Override
    public ViewType getView() {
        return this.view;
    }

    @Override
    public List<ObjectType> getObjectList() {
        return this.objects;
    }

    @Override
    public void saveObject(ObjectType obj, boolean add) {
        if (!this.validator.validate(obj)) {
            UIUtil.displayMessage(this.view.getShell(),
                "Save error",
                this.validator.getErrorMessage());

            return;
        }

        if (add) {
            this.objects.add(obj);
        }
        else {
            int idx = this.view.getList().getSelectionIndex();

            if (idx >= 0) {
                this.objects.set(idx, obj);
            }
        }

        this.refreshView(true);
    }

    @Override
    public void refreshView(boolean modelUpdated) {
        if (modelUpdated) {
            this.view.getList().removeAll();

            for(ObjectType obj : this.objects) {
                this.view.getList().add(obj.getName());
            }
        }

        this.updateEditor();
    }

    /**
     * Override this, initializes the validator
     */

    protected abstract void initValidator();

    /**
     * Override this, sets up the adapters (event listeners)
     */

    protected abstract void initAdapters();

    /**
     * Override this, sets up the controls (attaches adapters to the UI)
     */

    protected abstract void setUpControls();

    /**
     * Override this, updates the state of the view's editor
     */

    protected abstract void updateEditor();
}
