package worldbuilder.controller.locations.validators;

import worldbuilder.controller.base.validators.BaseValidator;
import worldbuilder.model.locations.Location;

/**
 * Location validator.
 *
 * Makes sure the fields of a location object are set.
 *
 * @author Stefan
 *
 */

public class LocationValidator extends BaseValidator<Location> {

    /**
     * The location validator's error message
     */

    private static final String ERROR_MESSAGE = "A location must have a name and a description";

    @Override
    protected boolean validateSpecific(Location obj) {
        return obj.getDescription().length() > 0;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
