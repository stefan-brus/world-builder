package worldbuilder.controller.base.adapters;

import worldbuilder.controller.base.BaseController;

/**
 * Base class for all remove adapters.
 *
 * @author Stefan Brus
 *
 * @param <ControllerType> The type of the controller
 */

public abstract class BaseRemoveAdapter<ControllerType extends BaseController<?, ?>>
    extends BaseAdapter<ControllerType> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseRemoveAdapter(ControllerType controller) {
        super(controller);
    }

    @Override
    protected void performAction() {
        String[] selected = this.controller.getView().getList().getSelection();

        if (selected.length > 0) {
            this.removeObject(selected[0]);

            this.controller.getView().getEditor().getNameField().setText("");

            this.clearEditor();

            this.controller.refreshView(true);
        }
    }

    /**
     * Override this, clear the editor's object specific fields.
     */

    protected abstract void clearEditor();

    /**
     * Override this, remove an object from the world
     *
     * @param name The name of the object to remove
     */

    protected abstract void removeObject(String name);
}
