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
        int idx = this.controller.getView().getList().getSelectionIndex();

        if (idx >= 0) {
            this.controller.getObjectList().remove(idx);

            this.controller.getView().getEditor().getNameField().setText("");

            this.clearEditor();

            this.controller.refreshView(true);
        }
    }

    /**
     * Override this, clear the editor's object specific fields.
     */

    protected abstract void clearEditor();
}
