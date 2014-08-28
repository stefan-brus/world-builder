package worldbuilder.controller.locations;

import org.eclipse.swt.events.SelectionAdapter;

import worldbuilder.controller.base.BaseController;
import worldbuilder.controller.locations.adapters.ListSelectionAdapter;
import worldbuilder.controller.locations.adapters.OpenAddDialogAdapter;
import worldbuilder.controller.locations.adapters.RemoveSelectionAdapter;
import worldbuilder.controller.locations.adapters.SaveSelectionAdapter;
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
        this.saveAdapter = new SaveSelectionAdapter(this);
        this.removeAdapter = new RemoveSelectionAdapter(this);
        this.listAdapter = new ListSelectionAdapter(this);
        this.addAdapter = new OpenAddDialogAdapter(this);
    }

    @Override
    protected void setUpControls() {
        this.view.getEditor().getSaveButton().addSelectionListener(this.saveAdapter);
        this.view.getEditor().getRemoveButton().addSelectionListener(this.removeAdapter);
        this.view.getList().addSelectionListener(this.listAdapter);
        this.view.getAddButton().addSelectionListener(this.addAdapter);
    }
}
