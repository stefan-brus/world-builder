package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.model.locations.Location;
import worldbuilder.view.locations.AddLocationDialog;

/**
 * This adapter opens the "add location" dialog
 *
 * @author Stefan Brus
 *
 */

public class OpenAddDialogAdapter extends SelectionAdapter {

    /**
     * Reference to the controller
     */

    private LocationsController controller;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public OpenAddDialogAdapter(LocationsController controller) {
        this.controller = controller;
    }

    /**
     * Button click handler
     *
     * @param e The event
     */

    @Override
    public void widgetSelected(SelectionEvent e) {
        AddLocationDialog dialog = new AddLocationDialog(this.controller.getView().getShell(), SWT.NONE);

        Location loc = dialog.open();

        if (loc != null && loc.getName() != null && loc.getDescription() != null) {
            this.controller.saveLocation(loc, true);
        }
    }
}
