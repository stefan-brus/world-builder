package worldbuilder.controller.base.validators;

import worldbuilder.model.base.BaseObject;

/**
 * Validator interface.
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The object type
 */

public interface IValidator<ObjectType extends BaseObject> {

    /**
     * Validate method.
     *
     * Validates the fields of the given object.
     *
     * @return True if the object is valid, false otherwise.
     */

    boolean validate(ObjectType obj);

    /**
     * Get this validator's error message
     */

    String getErrorMessage();
}
