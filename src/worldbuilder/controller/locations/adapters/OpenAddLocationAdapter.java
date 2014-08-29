package worldbuilder.controller.locations.adapters;

import org.eclipse.swt.SWT;

import worldbuilder.controller.base.adapters.BaseAddDialogAdapter;
import worldbuilder.controller.locations.LocationsController;
import worldbuilder.model.locations.Location;
import worldbuilder.view.locations.AddLocationDialog;

/**
 * This adapter opens the "add location" dialog
 *
 * @author Stefan Brus
 *
 */

public class OpenAddLocationAdapter extends BaseAddDialogAdapter<Location, AddLocationDialog, LocationsController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public OpenAddLocationAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    protected void createDialog() {
        this.dialog = new AddLocationDialog(this.controller.getView().getShell(), SWT.NONE);
    }
}
