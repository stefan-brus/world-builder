package worldbuilder.controller.base.adapters;

import worldbuilder.controller.base.BaseController;

public abstract class BaseSelectionAdapter<ControllerType extends BaseController<?, ?>> extends BaseAdapter<ControllerType> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseSelectionAdapter(ControllerType controller) {
        super(controller);
    }

    @Override
    public void performAction() {
        this.controller.refreshView(false);
    }
}
