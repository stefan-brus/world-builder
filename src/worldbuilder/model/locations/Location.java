package worldbuilder.model.locations;

/**
 * This POJO represents a location in the world.
 *
 * Contains location data fields, as well as access methods.
 *
 * @author Stefan Brus
 *
 */

public class Location {

    /**
     * The name of the location
     */

    private String name;

    /**
     * A description of the location
     */

    private String description;

    /**
     * Get the name
     *
     * @return The name
     */

    public String getName() {
        return this.name;
    }

    /**
     * Set the name
     *
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description
     *
     * @return The description
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description
     *
     * @param description The new description
     */

    public void setDescription(String description) {
        this.description = description;
    }
}
