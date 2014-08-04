package worldbuilder.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import worldbuilder.view.locations.LocationsView;

/**
 * Main window class.
 *
 * Contains the components that make up the world builder user interface.
 *
 * @author Stefan Brus
 *
 */

public class MainWindow extends Composite {

    /**
     * The layout object used by this window
     */

    private static final Layout MAIN_LAYOUT;

    static {
        MAIN_LAYOUT = new GridLayout(1, true);
    }

    /**
     * The main "logo" label
     */

    private Label logoLabel;

    /**
     * The tabbed interface container
     */

    private TabFolder tabs;

    /**
     * The locations view
     */

    private LocationsView locationsView;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public MainWindow(Composite parent, int style) {
    	super(parent, style);

    	this.initWindow();
    }

    /**
     * Get the locations view
     *
     * @return The locations view
     */

    public LocationsView getLocationsView() {
        return this.locationsView;
    }

    /**
     * Initialize the sub-components of the main window
     */

    private void initWindow() {
        this.setLayout(MAIN_LAYOUT);

        this.logoLabel = new Label(this, SWT.NONE);
        this.logoLabel.setText("World Builder");

        this.tabs = new TabFolder(this, SWT.NONE);

        TabItem locationsTab = new TabItem(this.tabs, SWT.NONE, 0);
        locationsTab.setText("Locations");

        this.locationsView = new LocationsView(this.tabs, SWT.NONE);
        locationsTab.setControl(this.locationsView);

        this.tabs.pack();
    }
}
