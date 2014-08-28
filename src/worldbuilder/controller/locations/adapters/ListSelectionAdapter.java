package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.controller.locations.adapters.base.BaseLocationsAdapter;

/**
 * Selection adapter for selecting locations from the list
 *
 * @author Stefan Brus
 *
 */

public class ListSelectionAdapter extends BaseLocationsAdapter {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public ListSelectionAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    public void performAction() {
        this.controller.refreshView(false);
    }
}
