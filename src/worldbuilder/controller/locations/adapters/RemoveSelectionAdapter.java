package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import worldbuilder.controller.locations.LocationsController;

/**
 * Selection adapter for removing locations
 *
 * @author Stefan Brus
 *
 */

public class RemoveSelectionAdapter extends SelectionAdapter {

    /**
     * Reference to the controller
     */

    private LocationsController controller;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public RemoveSelectionAdapter(LocationsController controller) {
        this.controller = controller;
    }

    /**
     * Button click handler
     *
     * @param e The event
     */

    @Override
    public void widgetSelected(SelectionEvent e) {
        int idx = this.controller.getView().getList().getSelectionIndex();

        if (idx >= 0) {
            this.controller.getLocations().remove(idx);

            this.controller.getView().getEditor().getNameField().setText("");
            this.controller.getView().getEditor().getDescField().setText("");

            this.controller.refreshLocationsList();
        }
    }
}
