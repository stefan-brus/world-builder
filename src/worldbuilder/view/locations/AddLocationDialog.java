package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import worldbuilder.model.locations.Location;
import worldbuilder.view.base.BaseAddDialog;

/**
 * The dialog used for adding a location, contains a LocationEditor
 *
 * @author Stefan
 *
 */

public class AddLocationDialog extends BaseAddDialog<Location, LocationEditor> {

    /**
     * Constructor
     *
     * @param parent The parent window
     * @param style The style
     */

    public AddLocationDialog(Shell parent, int style) {
        super(parent, style);
    }

    @Override
    protected void initDialog() {
        this.editor = new LocationEditor(this.shell, SWT.NONE);
        this.result = new Location();
    }

    @Override
    protected void setSpecificFields() {
        this.result.setDescription(this.editor.getDescField().getText());
    }
}
