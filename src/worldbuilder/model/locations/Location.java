package worldbuilder.model.locations;

import worldbuilder.model.base.BaseObject;

/**
 * This POJO represents a location in the world.
 *
 * Contains location data fields, as well as access methods.
 *
 * @author Stefan Brus
 *
 */

public class Location extends BaseObject {

    /**
     * A description of the location
     */

    private String description;

    /**
     * Constructor
     */

    public Location () {
        super("");

        this.description = "";
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
