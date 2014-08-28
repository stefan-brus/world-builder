package worldbuilder.view.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Base class for all editors.
 *
 * Contains 'save' and 'remove' buttons, and calls an abstract method to
 * set up the editor-specific fields before setting these up.
 *
 * @author Stefan Brus
 *
 */

public abstract class BaseEditor extends Composite implements IEditor {

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

    public BaseEditor(Composite parent, int style) {
        super(parent, style);

        this.initEditor();
    }

    @Override
    public Button getSaveButton() {
        return this.saveBtn;
    }

    @Override
    public Button getRemoveButton() {
        return this.removeBtn;
    }

    /**
     * Override this, initializes the fields specific to this editor
     */

    protected abstract void initFields();

    /**
     * Initialize the editor controls
     */

    private void initEditor() {
        this.setLayout(EDITOR_LAYOUT);

        this.initFields();

        Composite btnComp = new Composite(this, SWT.NONE);
        btnComp.setLayout(new RowLayout());

        this.saveBtn = new Button(btnComp, SWT.NONE);
        this.saveBtn.setText("Save");

        this.removeBtn = new Button(btnComp, SWT.NONE);
        this.removeBtn.setText("Remove");
    }
}
