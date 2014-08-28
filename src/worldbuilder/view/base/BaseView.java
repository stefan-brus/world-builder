package worldbuilder.view.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

/**
 * Base class for all views.
 *
 * Contains a list of items, an editor and an "add" button.
 *
 * The template argument is the type of the editor this view should use:
 *
 * @author Stefan Brus
 *
 * @param <EditorType> The editor's class.
 */

public abstract class BaseView<EditorType extends BaseEditor> extends Composite implements IView<EditorType> {

    /**
     * The editor
     */

    protected EditorType editor;

    /**
     * The list of items for this view
     */

    private List items;

    /**
     * The add button
     */

    private Button addBtn;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public BaseView(Composite parent, int style) {
        super(parent, style);

        this.initView();
    }

    @Override
    public List getList() {
        return this.items;
    }

    @Override
    public EditorType getEditor() {
        return this.editor;
    }

    @Override
    public Button getAddButton() {
        return this.addBtn;
    }

    /**
     * Override this, initializes the editor
     */

    protected abstract void initEditor();

    /**
     * Initialize the view
     */

    private void initView() {
        this.setLayout(VIEW_LAYOUT);

        GridLayout listLayout = new GridLayout();

        Composite listComp = new Composite(this, SWT.NONE);
        listComp.setLayout(listLayout);

        this.items = new List(listComp, SWT.BORDER);

        this.addBtn = new Button(listComp, SWT.NONE);
        this.addBtn.setText("Add...");

        this.initEditor();
    }
}
