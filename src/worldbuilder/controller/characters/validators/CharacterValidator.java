package worldbuilder.controller.characters.validators;

import worldbuilder.controller.base.validators.BaseValidator;
/**
 * Character validator.
 *
 * Makes sure the fields of a character object are set.
 *
 * @author Stefan
 *
 */
import worldbuilder.model.characters.Character;

public class CharacterValidator extends BaseValidator<Character> {

    /**
     * The character validator's error message
     */

    private static final String ERROR_MESSAGE = "A character must have a name, year of birth, place of birth and background";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }

    @Override
    protected boolean validateSpecific(Character obj) {
        return obj.getPlaceOfBirth() != null &&
               obj.getBackground().length() > 0;
    }

}
