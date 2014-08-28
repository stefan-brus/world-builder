package worldbuilder.controller.base.validators;

import worldbuilder.model.base.BaseObject;

/**
 * Validator base class.
 *
 * Makes sure the fields common to all objects are set.
 *
 * @author Stefan
 *
 * @param <ObjectType> The object type
 */

public abstract class BaseValidator<ObjectType extends BaseObject> implements IValidator<ObjectType> {

    @Override
    public boolean validate(ObjectType obj) {
        return obj.getName().length() > 0 && this.validateSpecific(obj);
    }

    /**
     * Override this, validates fields specific to the object type
     */

    protected abstract boolean validateSpecific(ObjectType obj);
}
