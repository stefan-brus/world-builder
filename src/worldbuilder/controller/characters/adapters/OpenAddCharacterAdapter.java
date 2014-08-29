package worldbuilder.controller.characters.adapters;

import org.eclipse.swt.SWT;

import worldbuilder.controller.base.adapters.BaseAddDialogAdapter;
import worldbuilder.controller.characters.CharactersController;
import worldbuilder.model.characters.Character;
import worldbuilder.view.characters.AddCharacterDialog;

/**
 * Selection adapter for opening the add character dialog
 *
 * @author Stefan Brus
 *
 */

public class OpenAddCharacterAdapter extends BaseAddDialogAdapter<Character, AddCharacterDialog, CharactersController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public OpenAddCharacterAdapter(CharactersController controller) {
        super(controller);
    }

    @Override
    protected void createDialog() {
        this.dialog = new AddCharacterDialog(this.controller.getView().getShell(), SWT.NONE);
    }

}
