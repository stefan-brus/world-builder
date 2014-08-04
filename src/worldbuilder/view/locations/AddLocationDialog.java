package worldbuilder.view.locations;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import worldbuilder.model.locations.Location;

/**
 * The dialog used for adding a location, contains a LocationEditor
 *
 * @author Stefan
 *
 */

public class AddLocationDialog extends Dialog {

    /**
     * Constructor
     *
     * @param parent The parent window
     * @param style The style
     */

    public AddLocationDialog(Shell parent, int style) {
        super(parent, style);

        this.initDialog();
    }

    /**
     * Open the dialog
     */

    public Location open() {
        Shell parent = this.getParent();
        Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell.setText(this.getText());
        shell.setLayout(new FillLayout());

        LocationEditor editor = new LocationEditor(shell, SWT.NONE);
        editor.getRemoveButton().dispose();

        Location result = new Location();

        editor.getSaveButton().addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                result.setName(editor.getNameField().getText());
                result.setDescription(editor.getDescField().getText());

                shell.dispose();
            }
        });

        shell.pack();
        shell.open();

        Display display = parent.getDisplay();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return result;
    }

    /**
     * Initialize the dialog
     */

    private void initDialog() {
        this.setText("Add location");
    }
}
