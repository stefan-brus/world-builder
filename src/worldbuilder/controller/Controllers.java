package worldbuilder.controller;

import worldbuilder.controller.locations.LocationsController;
import worldbuilder.view.MainWindow;

/**
 * This class sets up all the controllers
 *
 * @author Stefan Brus
 *
 */

public class Controllers {

    /**
     * The main window reference
     */

    private MainWindow mainWindow;

    /**
     * The locations controller
     */

    @SuppressWarnings("unused")
    private LocationsController locationsController;

    /**
     * Constructor
     *
     * @param mainWindow The main window reference
     */

    public Controllers(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        this.setUpControllers();
    }

    /**
     * Set up the controllers
     */

    private void setUpControllers() {
        this.locationsController = new LocationsController(this.mainWindow.getLocationsView());
    }
}
