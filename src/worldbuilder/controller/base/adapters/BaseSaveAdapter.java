package worldbuilder.controller.base.adapters;

import worldbuilder.controller.base.BaseController;
import worldbuilder.model.base.BaseObject;

/**
 * Base class for all save adapters
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The type of the object to save
 * @param <ControllerType> The type of the controller
 */

public abstract class BaseSaveAdapter<ObjectType extends BaseObject, ControllerType extends BaseController<ObjectType, ?>>
    extends BaseAdapter<ControllerType> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseSaveAdapter(ControllerType controller) {
        super(controller);
    }

    @Override
    protected void performAction() {
        String name = this.controller.getView().getEditor().getNameField().getText();

        ObjectType obj = this.createObject();

        obj.setName(name);

        this.controller.saveObject(obj);
    }

    /**
     * Override this, create and return an object with its specific fields
     * filled in from the editor field contents.
     *
     * @return The created object
     */

    protected abstract ObjectType createObject();
}
