package worldbuilder.view.characters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import worldbuilder.view.base.BaseView;

/**
 * The characters view.
 *
 * @author Stefan Brus
 *
 */

public class CharactersView extends BaseView<CharacterEditor> {

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public CharactersView(Composite parent, int style) {
        super(parent, style);
    }

    @Override
    protected void initEditor() {
        this.editor = new CharacterEditor(this, SWT.NONE);

        this.editor.getNameField().setEnabled(false);
        this.editor.getBirthYearField().setEnabled(false);
        this.editor.getBirthPlaceField().setEnabled(false);
        this.editor.getBackgroundField().setEnabled(false);
    }
}
