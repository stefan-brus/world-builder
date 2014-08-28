package worldbuilder.controller.locations.adapters.base;

import worldbuilder.controller.base.adapters.BaseAdapter;
import worldbuilder.controller.locations.LocationsController;

public abstract class BaseLocationsAdapter extends BaseAdapter<LocationsController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseLocationsAdapter(LocationsController controller) {
        super(controller);
    }
}
