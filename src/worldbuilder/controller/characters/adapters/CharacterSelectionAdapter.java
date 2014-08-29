package worldbuilder.controller.characters.adapters;

import worldbuilder.controller.base.adapters.BaseSelectionAdapter;
import worldbuilder.controller.characters.CharactersController;

/**
 * Selection adapter for selecting a character
 *
 * @author Stefan Brus
 *
 */

public class CharacterSelectionAdapter extends BaseSelectionAdapter<CharactersController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public CharacterSelectionAdapter(CharactersController controller) {
        super(controller);
    }
}
