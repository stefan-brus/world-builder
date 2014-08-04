package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;

/**
 * The locations editor view.
 *
 * Contains a list of locations, as well as controls to
 * edit/add/remove locations.
 *
 * @author Stefan Brus
 *
 */
public class LocationsView extends Composite {

    /**
     * The layout object used by this window
     */

    private static final Layout LOCATIONS_LAYOUT;

    static {
        LOCATIONS_LAYOUT = new GridLayout(2, false);
    }

    /**
     * The locations list
     */

    private List locations;

    /**
     * The location editor
     */

    private LocationEditor editor;

    /**
     * The add location button
     */

    private Button addBtn;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public LocationsView(Composite parent, int style) {
        super(parent, style);

        this.initView();
    }

    /**
     * Get the locations list
     *
     * @return The locations list
     */

    public List getList() {
        return this.locations;
    }

    /**
     * Get the editor
     *
     * @return The editor
     */

    public LocationEditor getEditor() {
        return this.editor;
    }

    /**
     * Get the add button
     *
     * @return The add button
     */

    public Button getAddButton() {
        return this.addBtn;
    }

    /**
     * Initialize the sub-components of this view
     */

    private void initView() {
        this.setLayout(LOCATIONS_LAYOUT);

        GridLayout listLayout = new GridLayout();

        Composite listComp = new Composite(this, SWT.NONE);
        listComp.setLayout(listLayout);

        this.locations = new List(listComp, SWT.BORDER);

        this.addBtn = new Button(listComp, SWT.NONE);
        this.addBtn.setText("Add...");

        this.editor = new LocationEditor(this, SWT.NONE);
    }
}
