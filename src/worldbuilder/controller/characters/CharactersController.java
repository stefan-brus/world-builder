package worldbuilder.controller.characters;

import worldbuilder.controller.base.BaseController;
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
        // TODO Auto-generated method stub

    }

    @Override
    protected void setUpControls() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void updateEditor() {
        // TODO Auto-generated method stub

    }

}
