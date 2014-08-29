package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.base.adapters.BaseRemoveAdapter;
import worldbuilder.controller.locations.LocationsController;

/**
 * Selection adapter for removing locations
 *
 * @author Stefan Brus
 *
 */

public class RemoveLocationAdapter extends BaseRemoveAdapter<LocationsController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public RemoveLocationAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    protected void clearEditor() {
        this.controller.getView().getEditor().getDescField().setText("");
    }
}
