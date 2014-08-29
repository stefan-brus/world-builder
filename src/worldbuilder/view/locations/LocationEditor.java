package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import worldbuilder.view.base.BaseEditor;

/**
 * The location editor component.
 *
 * @author Stefan Brus
 *
 */

public class LocationEditor extends BaseEditor {

    /**
     * The description text field
     */

    private Text descField;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public LocationEditor(Composite parent, int style) {
        super(parent, style);
    }

    /**
     * Get the description field
     *
     * @return The description button
     */

    public Text getDescField() {
        return this.descField;
    }

    @Override
    protected void initFields() {
        Label descLbl = new Label(this, SWT.NONE);
        descLbl.setText("Description");

        this.descField = new Text(this, SWT.MULTI | SWT.BORDER);
    }
}
