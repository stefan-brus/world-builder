package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.controller.locations.adapters.base.BaseLocationsAdapter;
import worldbuilder.model.locations.Location;

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
        int idx = this.controller.getView().getList().getSelectionIndex();

        if (idx >= 0)
        {
            Location loc = this.controller.getObjectList().get(idx);

            this.controller.getView().getEditor().getNameField().setText(loc.getName());
            this.controller.getView().getEditor().getDescField().setText(loc.getDescription());
        }
    }
}
