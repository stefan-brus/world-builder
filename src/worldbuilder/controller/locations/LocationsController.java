package worldbuilder.controller.locations;

import org.eclipse.swt.events.SelectionAdapter;

import worldbuilder.controller.base.BaseController;
import worldbuilder.controller.locations.adapters.LocationSelectionAdapter;
import worldbuilder.controller.locations.adapters.OpenAddLocationAdapter;
import worldbuilder.controller.locations.adapters.RemoveLocationAdapter;
import worldbuilder.controller.locations.adapters.SaveLocationAdapter;
import worldbuilder.controller.locations.validators.LocationValidator;
import worldbuilder.model.locations.Location;
import worldbuilder.view.locations.LocationsView;

/**
 * Locations controller class, handles UI events and manages
 * the internal and external storage of locations.
 *
 * @author Stefan Brus
 *
 */

public class LocationsController extends BaseController<Location, LocationsView> {

    /**
     * The event listener for the save button
     */

    private SelectionAdapter saveAdapter;

    /**
     * The event listener for the remove button
     */

    private SelectionAdapter removeAdapter;

    /**
     * The event listener for the locations list
     */

    private SelectionAdapter listAdapter;

    /**
     * The event listener for the add button
     */

    private SelectionAdapter addAdapter;

    /**
     * Constructor
     *
     * @param view The locations view reference
     */

    public LocationsController(LocationsView view) {
        super(view);
    }

    @Override
    protected void initValidator() {
        this.validator = new LocationValidator();
    }

    @Override
    protected void initAdapters() {
        this.saveAdapter = new SaveLocationAdapter(this);
        this.removeAdapter = new RemoveLocationAdapter(this);
        this.listAdapter = new LocationSelectionAdapter(this);
        this.addAdapter = new OpenAddLocationAdapter(this);
    }

    @Override
    protected void setUpControls() {
        this.view.getEditor().getSaveButton().addSelectionListener(this.saveAdapter);
        this.view.getEditor().getRemoveButton().addSelectionListener(this.removeAdapter);
        this.view.getList().addSelectionListener(this.listAdapter);
        this.view.getAddButton().addSelectionListener(this.addAdapter);
    }

    @Override
    protected void updateEditor() {
        int idx = this.view.getList().getSelectionIndex();

        if (idx >= 0) {
            Location loc = this.objects.get(idx);

            this.view.getEditor().getNameField().setText(loc.getName());
            this.view.getEditor().getDescField().setText(loc.getDescription());

            this.view.getEditor().getNameField().setEnabled(true);
            this.view.getEditor().getDescField().setEnabled(true);
        }
        else {
            this.view.getEditor().getNameField().setText("");
            this.view.getEditor().getDescField().setText("");

            this.view.getEditor().getNameField().setEnabled(false);
            this.view.getEditor().getDescField().setEnabled(false);
        }
    }
}
