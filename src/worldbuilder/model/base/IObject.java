package worldbuilder.model.base;

/**
 * Object interface.
 *
 * Contains access methods common to all objects.
 *
 * @author Stefan Brus
 *
 */

public interface IObject {

    /**
     * Get the name
     *
     * @return The name
     */

    String getName();

    /**
     * Set the name
     *
     * @param name The new name
     */

    void setName(String name);
}
