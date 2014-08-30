package worldbuilder.controller.locations;

import worldbuilder.controller.base.BaseController;
import worldbuilder.controller.locations.adapters.LocationSelectionAdapter;
import worldbuilder.controller.locations.adapters.OpenAddLocationAdapter;
import worldbuilder.controller.locations.adapters.RemoveLocationAdapter;
import worldbuilder.controller.locations.adapters.SaveLocationAdapter;
import worldbuilder.controller.locations.validators.LocationValidator;
import worldbuilder.model.World;
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
    protected void updateEditor() {
        String[] selected = this.view.getList().getSelection();

        if (selected.length > 0) {
            Location loc = World.instance().getLocation(selected[0]);

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

    @Override
    protected void saveSpecificObject(Location obj) {
        World.instance().putLocation(obj);
    }

    @Override
    protected String[] getObjectNames() {
        return World.instance().getLocations().stream().map((obj) -> obj.getName()).toArray(String[]::new);
    }
}
