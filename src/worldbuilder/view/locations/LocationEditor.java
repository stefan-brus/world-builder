package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

/**
 * The location editor component.
 *
 * Contains controls to edit, save, add and remove locations.
 *
 * @author Stefan Brus
 *
 */

public class LocationEditor extends Composite {

    /**
     * The layout object used by this window
     */

    private static final Layout LOCATIONS_EDITOR_LAYOUT;

    static {
        LOCATIONS_EDITOR_LAYOUT = new GridLayout(2, false);
    }

    /**
     * The name text field
     */

    private Text nameField;

    /**
     * The description text field
     */

    private Text descField;

    /**
     * The save button
     */

    private Button saveBtn;

    /**
     * The remove button
     */

    private Button removeBtn;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public LocationEditor(Composite parent, int style) {
        super(parent, style);

        this.initEditor();
    }

    /**
     * Get the name field
     *
     * @return The name field
     */

    public Text getNameField() {
        return this.nameField;
    }

    /**
     * Get the description field
     *
     * @return The description button
     */

    public Text getDescField() {
        return this.descField;
    }

    /**
     * Get the save button
     *
     * @return The save button
     */

    public Button getSaveButton() {
        return this.saveBtn;
    }

    /**
     * Get the remove button
     *
     * @return The remove button
     */

    public Button getRemoveButton() {
        return this.removeBtn;
    }

    /**
     * Initialize the editor controls
     */

    private void initEditor() {
        this.setLayout(LOCATIONS_EDITOR_LAYOUT);

        Label nameLbl = new Label(this, SWT.NONE);
        nameLbl.setText("Name");

        this.nameField = new Text(this, SWT.SINGLE | SWT.BORDER);

        Label descLbl = new Label(this, SWT.NONE);
        descLbl.setText("Description");

        this.descField = new Text(this, SWT.MULTI | SWT.BORDER);

        Composite btnComp = new Composite(this, SWT.NONE);
        btnComp.setLayout(new RowLayout());

        this.saveBtn = new Button(btnComp, SWT.NONE);
        this.saveBtn.setText("Save");

        this.removeBtn = new Button(btnComp, SWT.NONE);
        this.removeBtn.setText("Remove");
    }
}
