package worldbuilder.view.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import worldbuilder.model.base.BaseObject;

/**
 * Base class for all add object dialogs.
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The object type
 * @param <EditorType> The editor type
 */

public abstract class BaseAddDialog<ObjectType extends BaseObject, EditorType extends BaseEditor>
    extends Dialog {

    /**
     * The editor
     */

    protected EditorType editor;

    /**
     * The created object
     */

    protected ObjectType result;

    /**
     * The save state
     */

    private DialogSaveState saveState;

    /**
     * The shell containing the dialog
     */

    protected Shell shell;

    /**
     * Constructor
     *
     * @param parent The parent window
     * @param style The style
     */

    public BaseAddDialog(Shell parent, int style) {
        super(parent, style);

        this.saveState = new DialogSaveState();
        this.shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

        this.initDialog();
    }

    /**
     * Open the dialog
     *
     * @return The created object
     */

    public ObjectType open() {
        Shell parent = this.getParent();
        this.shell.setText(this.getText());
        this.shell.setLayout(new FillLayout());

        this.editor.getRemoveButton().dispose();

        this.editor.getSaveButton().addSelectionListener(new DialogSaveAdapter(this));

        this.shell.pack();
        this.shell.open();

        Display display = parent.getDisplay();

        while (!this.shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        return this.saveState.hasSaved() ? this.result : null;
    }

    /**
     * Override this, initialize the dialog
     */

    protected abstract void initDialog();

    /**
     * Override this, set the object type specific fields of the result
     */

    protected abstract void setSpecificFields();

    /**
     * Internal adapter for the dialog's save button
     */

    private class DialogSaveAdapter extends SelectionAdapter {

        /**
         * Reference to the dialog
         */

        private BaseAddDialog<?, ?> dialog;

        /**
         * Constructor
         *
         * @param dialog Reference to the dialog
         */

        public DialogSaveAdapter(BaseAddDialog<?, ?> dialog) {
            this.dialog = dialog;
        }

        @Override
        public void widgetSelected(SelectionEvent e) {
            this.dialog.result.setName(this.dialog.editor.getNameField().getText());

            this.dialog.setSpecificFields();

            this.dialog.saveState.setSaved();

            this.dialog.shell.dispose();
        }
    }

    /**
     * Internal state wrapper for whether or not the save button has been pressed
     *
     * @author Stefan Brus
     *
     */

    private class DialogSaveState {

        /**
         * Has the save button been pressed?
         */

        private boolean saved = false;

        /**
         * Set the state to true
         */

        public void setSaved() {
            this.saved = true;
        }

        /**
         * Get the saved state
         *
         * @return The dialog's saved state
         */

        public boolean hasSaved() {
            return this.saved;
        }
    }
}
