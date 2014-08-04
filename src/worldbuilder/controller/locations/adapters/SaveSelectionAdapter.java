package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.model.locations.Location;

/**
 * Selection adapter for saving locations
 *
 * @author Stefan Brus
 *
 */

public class SaveSelectionAdapter extends SelectionAdapter {

    /**
     * Reference to the controller
     */

    private LocationsController controller;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public SaveSelectionAdapter(LocationsController controller) {
        this.controller = controller;
    }

    /**
     * Button click handler
     *
     * @param e The event
     */

    @Override
    public void widgetSelected(SelectionEvent e) {
        String locName = this.controller.getView().getEditor().getNameField().getText();
        String locDesc = this.controller.getView().getEditor().getDescField().getText();

        Location loc = new Location();
        loc.setName(locName);
        loc.setDescription(locDesc);

        this.controller.saveLocation(loc, false);
    }
}