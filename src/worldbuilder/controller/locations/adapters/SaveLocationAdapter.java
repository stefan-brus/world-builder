package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.base.adapters.BaseSaveAdapter;
import worldbuilder.controller.locations.LocationsController;
import worldbuilder.model.locations.Location;

/**
 * Adapter for saving locations
 *
 * @author Stefan Brus
 *
 */

public class SaveLocationAdapter extends BaseSaveAdapter<Location, LocationsController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public SaveLocationAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    protected Location createObject() {
        Location loc = new Location();

        loc.setDescription(this.controller.getView().getEditor().getDescField().getText());

        return loc;
    }
}