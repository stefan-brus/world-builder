package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.model.locations.Location;

/**
 * Selection adapter for selecting locations from the list
 *
 * @author Stefan Brus
 *
 */

public class ListSelectionAdapter extends SelectionAdapter {

    /**
     * Reference to the controller
     */

    private LocationsController controller;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public ListSelectionAdapter(LocationsController controller) {
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

        if (idx >= 0)
        {
            Location loc = this.controller.getObjectList().get(idx);

            this.controller.getView().getEditor().getNameField().setText(loc.getName());
            this.controller.getView().getEditor().getDescField().setText(loc.getDescription());
        }
    }
}
