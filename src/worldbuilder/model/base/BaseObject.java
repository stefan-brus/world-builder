package worldbuilder.model.base;

/**
 * This class contains fields common to all objects.
 *
 * @author Stefan
 *
 */

public abstract class BaseObject implements IObject {

    /**
     * The name of the character
     */

    private String name;

    /**
     * Constructor
     *
     * @param name = The name of this object
     */

    protected BaseObject(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
