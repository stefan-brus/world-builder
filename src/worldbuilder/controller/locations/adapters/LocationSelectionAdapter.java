package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.base.adapters.BaseSelectionAdapter;
import worldbuilder.controller.locations.LocationsController;

/**
 * Selection adapter for selecting locations from the list
 *
 * @author Stefan Brus
 *
 */

public class LocationSelectionAdapter extends BaseSelectionAdapter<LocationsController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public LocationSelectionAdapter(LocationsController controller) {
        super(controller);
    }
}
