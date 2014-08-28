package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.controller.locations.adapters.base.BaseLocationsAdapter;
import worldbuilder.model.locations.Location;

/**
 * Adapter for saving locations
 *
 * @author Stefan Brus
 *
 */

public class SaveAdapter extends BaseLocationsAdapter {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public SaveAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    public void performAction() {
        String locName = this.controller.getView().getEditor().getNameField().getText();
        String locDesc = this.controller.getView().getEditor().getDescField().getText();

        Location loc = new Location();
        loc.setName(locName);
        loc.setDescription(locDesc);

        this.controller.saveObject(loc, false);
    }
}