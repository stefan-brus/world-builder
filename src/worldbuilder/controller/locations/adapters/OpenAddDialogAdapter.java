package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.SWT;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.controller.locations.adapters.base.BaseLocationsAdapter;
import worldbuilder.model.locations.Location;
import worldbuilder.view.locations.AddLocationDialog;

/**
 * This adapter opens the "add location" dialog
 *
 * @author Stefan Brus
 *
 */

public class OpenAddDialogAdapter extends BaseLocationsAdapter {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public OpenAddDialogAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    public void performAction() {
        AddLocationDialog dialog = new AddLocationDialog(this.controller.getView().getShell(), SWT.NONE);

        Location loc = dialog.open();

        if (loc != null && loc.getName() != null && loc.getDescription() != null) {
            this.controller.saveObject(loc, true);
        }
    }
}
