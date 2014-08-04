package worldbuilder.controller.locations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;

import worldbuilder.controller.locations.adapters.ListSelectionAdapter;
import worldbuilder.controller.locations.adapters.OpenAddDialogAdapter;
import worldbuilder.controller.locations.adapters.RemoveSelectionAdapter;
import worldbuilder.controller.locations.adapters.SaveSelectionAdapter;
import worldbuilder.model.locations.Location;
import worldbuilder.util.UIUtil;
import worldbuilder.view.locations.LocationsView;

/**
 * Locations controller class, handles UI events and manages
 * the internal and external storage of locations.
 *
 * @author Stefan Brus
 *
 */

public class LocationsController {

    /**
     * The locations view reference
     */

    private LocationsView view;

    /**
     * The collection of locations
     */

    private List<Location> locations;

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

    private ListSelectionAdapter listAdapter;

    /**
     * The event listener for the add button
     */

    private OpenAddDialogAdapter addAdapter;

    /**
     * Constructor
     *
     * @param view The locations view reference
     */

    public LocationsController(LocationsView view) {
        this.view = view;
        this.locations = new ArrayList<Location>();

        this.setUpAdapters();
        this.setUpControls();
    }

    /**
     * Get the locations view
     *
     * @return The locations view
     */

    public LocationsView getView() {
        return this.view;
    }

    /**
     * Get the locations list
     *
     * @return The locations list
     */

    public List<Location> getLocations() {
        return this.locations;
    }

    /**
     * Save a location in the list
     *
     * @param loc The location
     * @param add If true, add the location, else save it at the current index
     */

    public void saveLocation(Location loc, boolean add) {
        if (loc.getName().length() == 0 || loc.getDescription().length() == 0) {
            UIUtil.displayMessage(this.view.getShell(),
                "Save error",
                "A location must have a name and a description");

            return;
        }

        if (add) {
            this.locations.add(loc);
        }
        else {
            int idx = this.view.getList().getSelectionIndex();

            if (idx >= 0) {
                this.locations.set(idx, loc);
            }
        }

        this.refreshLocationsList();
    }

    /**
     * Refresh the locations list view
     */

    public void refreshLocationsList() {
        this.view.getList().removeAll();

        for(Location loc : this.getLocations()) {
            this.view.getList().add(loc.getName());
        }
    }

    /**
     * Set up the adapters (event listeners)
     */

    private void setUpAdapters() {
        this.saveAdapter = new SaveSelectionAdapter(this);
        this.removeAdapter = new RemoveSelectionAdapter(this);
        this.listAdapter = new ListSelectionAdapter(this);
        this.addAdapter = new OpenAddDialogAdapter(this);
    }

    /**
     * Set up the event listeners in the UI
     */

    private void setUpControls() {
        this.view.getEditor().getSaveButton().addSelectionListener(this.saveAdapter);
        this.view.getEditor().getRemoveButton().addSelectionListener(this.removeAdapter);
        this.view.getList().addSelectionListener(this.listAdapter);
        this.view.getAddButton().addSelectionListener(this.addAdapter);
    }
}
