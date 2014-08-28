package worldbuilder.model.base;

/**
 * This class contains fields common to all objects.
 *
 * @author Stefan
 *
 */

public class BaseObject implements IObject {

    /**
     * The name of the character
     */

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
