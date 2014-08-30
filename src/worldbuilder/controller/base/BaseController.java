package worldbuilder.controller.base;

import org.eclipse.swt.events.SelectionAdapter;

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
     * The event listener for the save button
     */

    protected SelectionAdapter saveAdapter;

    /**
     * The event listener for the remove button
     */

    protected SelectionAdapter removeAdapter;

    /**
     * The event listener for the locations list
     */

    protected SelectionAdapter listAdapter;

    /**
     * The event listener for the add button
     */

    protected SelectionAdapter addAdapter;

    /**
     * Constructor
     *
     * @param view The view reference
     */

    public BaseController(ViewType view) {
        this.view = view;

        this.initValidator();
        this.initAdapters();
        this.setUpControls();
    }

    @Override
    public ViewType getView() {
        return this.view;
    }

    @Override
    public void saveObject(ObjectType obj) {
        if (!this.validator.validate(obj)) {
            UIUtil.displayMessage(this.view.getShell(),
                "Save error",
                this.validator.getErrorMessage());

            return;
        }

        this.saveSpecificObject(obj);

        this.refreshView(true);
    }

    @Override
    public void refreshView(boolean modelUpdated) {
        if (modelUpdated) {
            this.view.getList().removeAll();

            for(String name : this.getObjectNames()) {
                this.view.getList().add(name);
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
     * Override this, updates the state of the view's editor
     */

    protected abstract void updateEditor();

    /**
     * Override this, save a specific object
     */

    protected abstract void saveSpecificObject(ObjectType obj);

    /**
     * Get the names of all objects
     *
     * @return An array with all object names
     */

    protected abstract String[] getObjectNames();

    /**
     * Set up the controls (attaches adapters to the UI)
     */

    private void setUpControls() {
        this.view.getEditor().getSaveButton().addSelectionListener(this.saveAdapter);
        this.view.getEditor().getRemoveButton().addSelectionListener(this.removeAdapter);
        this.view.getList().addSelectionListener(this.listAdapter);
        this.view.getAddButton().addSelectionListener(this.addAdapter);
    }
}
