package worldbuilder.view.characters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import worldbuilder.model.characters.Character;
import worldbuilder.model.locations.Location;
import worldbuilder.view.base.BaseAddDialog;

/**
 * The dialog used for adding a character
 *
 * @author Stefan Brus
 *
 */

public class AddCharacterDialog extends BaseAddDialog<Character, CharacterEditor> {

    /**
     * Constructor
     *
     * @param parent The parent window
     * @param style The style
     */

    public AddCharacterDialog(Shell parent, int style) {
        super(parent, style);
    }

    @Override
    protected void initDialog() {
        this.editor = new CharacterEditor(this.shell, SWT.NONE);
        this.result = new Character();
    }

    @Override
    protected void setSpecificFields() {
        this.result.setYearOfBirth(this.editor.getBirthYearField().getSelection());
        // TODO: Add the selected location
        this.result.setPlaceOfBirth(new Location());
        this.result.setBackground(this.editor.getBackgroundField().getText());
    }

}
