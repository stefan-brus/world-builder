package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import worldbuilder.view.base.BaseView;

/**
 * The locations view.
 *
 * @author Stefan Brus
 *
 */

public class LocationsView extends BaseView<LocationEditor> {

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public LocationsView(Composite parent, int style) {
        super(parent, style);
    }

    @Override
    protected void initEditor() {
        this.editor = new LocationEditor(this, SWT.NONE);

        this.editor.getNameField().setEnabled(false);
        this.editor.getDescField().setEnabled(false);
    }

}
