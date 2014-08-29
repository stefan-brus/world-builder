package worldbuilder.controller.characters.adapters;

import worldbuilder.controller.base.adapters.BaseSaveAdapter;
import worldbuilder.controller.characters.CharactersController;
import worldbuilder.model.characters.Character;
import worldbuilder.model.locations.Location;

/**
 * Adapter for saving characters
 *
 * @author Stefan Brus
 *
 */

public class SaveCharacterAdapter extends BaseSaveAdapter<Character, CharactersController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public SaveCharacterAdapter(CharactersController controller) {
        super(controller);
    }

    @Override
    protected Character createObject() {
        Character chr = new Character();

        chr.setYearOfBirth(this.controller.getView().getEditor().getBirthYearField().getSelection());
        // TODO: Set to the selected location
        chr.setPlaceOfBirth(new Location());
        chr.setBackground(this.controller.getView().getEditor().getBackgroundField().getText());

        return chr;
    }
}
