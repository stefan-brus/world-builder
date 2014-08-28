package worldbuilder.controller.locations.adapters;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.controller.locations.adapters.base.BaseLocationsAdapter;

/**
 * Selection adapter for removing locations
 *
 * @author Stefan Brus
 *
 */

public class RemoveAdapter extends BaseLocationsAdapter {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public RemoveAdapter(LocationsController controller) {
        super(controller);
    }

    @Override
    public void performAction() {
        int idx = this.controller.getView().getList().getSelectionIndex();

        if (idx >= 0) {
            this.controller.getObjectList().remove(idx);

            this.controller.getView().getEditor().getNameField().setText("");
            this.controller.getView().getEditor().getDescField().setText("");

            this.controller.refreshView();
        }
    }
}
