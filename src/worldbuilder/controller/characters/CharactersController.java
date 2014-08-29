package worldbuilder.controller.characters;

import worldbuilder.controller.base.BaseController;
import worldbuilder.controller.characters.adapters.CharacterSelectionAdapter;
import worldbuilder.controller.characters.adapters.OpenAddCharacterAdapter;
import worldbuilder.controller.characters.adapters.RemoveCharacterAdapter;
import worldbuilder.controller.characters.adapters.SaveCharacterAdapter;
import worldbuilder.controller.characters.validators.CharacterValidator;
import worldbuilder.model.characters.Character;
import worldbuilder.view.characters.CharactersView;

/**
 * Characters controller class, handles UI events and manages
 * the internal and external storage of characters.
 *
 * @author Stefan Brus
 *
 */

public class CharactersController extends BaseController<Character, CharactersView> {

    /**
     * Constructor
     *
     * @param view The characters view reference
     */

    public CharactersController(CharactersView view) {
        super(view);
    }

    @Override
    protected void initValidator() {
        this.validator = new CharacterValidator();
    }

    @Override
    protected void initAdapters() {
        this.saveAdapter = new SaveCharacterAdapter(this);
        this.removeAdapter = new RemoveCharacterAdapter(this);
        this.listAdapter = new CharacterSelectionAdapter(this);
        this.addAdapter = new OpenAddCharacterAdapter(this);
    }

    @Override
    protected void updateEditor() {
        int idx = this.view.getList().getSelectionIndex();

        if (idx >= 0) {
            Character chr = this.objects.get(idx);

            this.view.getEditor().getNameField().setText(chr.getName());
            this.view.getEditor().getBirthYearField().setSelection(chr.getYearOfBirth());
            // TODO: Set to all available locations, and the character's location
            // Might be worth creating a new widget for this field
            this.view.getEditor().getBirthPlaceField().setItems(new String[0]);
            this.view.getEditor().getBackgroundField().setText(chr.getBackground());

            this.view.getEditor().getNameField().setEnabled(true);
            this.view.getEditor().getBirthYearField().setEnabled(true);
            this.view.getEditor().getBirthPlaceField().setEnabled(true);
            this.view.getEditor().getBackgroundField().setEnabled(true);
        }
        else {
            this.view.getEditor().getNameField().setText("");
            this.view.getEditor().getBirthYearField().setSelection(0);
            // TODO: Set to all available locations
            this.view.getEditor().getBirthPlaceField().setItems(new String[0]);
            this.view.getEditor().getBackgroundField().setText("");

            this.view.getEditor().getNameField().setEnabled(false);
            this.view.getEditor().getBirthYearField().setEnabled(false);
            this.view.getEditor().getBirthPlaceField().setEnabled(false);
            this.view.getEditor().getBackgroundField().setEnabled(false);
        }
    }

}
