package worldbuilder.controller.base.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import worldbuilder.controller.base.BaseController;

/**
 * Base class for selection adapters, aka event handlers.
 *
 * @author Stefan Brus
 *
 * @param <ControllerType> The type of the controller
 */

public abstract class BaseAdapter<ControllerType extends BaseController<?, ?>> extends SelectionAdapter {

    /**
     * Reference to the controller
     */

    protected ControllerType controller;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseAdapter(ControllerType controller) {
        this.controller = controller;
    }

    /**
     * Button click handler
     *
     * @param e The event
     */

    @Override
    public void widgetSelected(SelectionEvent e) {
        this.performAction();
    }

    /**
     * Override this, perform actions specific to the adapter
     */

    protected abstract void performAction();
}
