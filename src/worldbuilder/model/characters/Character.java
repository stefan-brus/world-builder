package worldbuilder.model.characters;

import worldbuilder.model.base.BaseObject;
import worldbuilder.model.locations.Location;

/**
 * This POJO represents a character.
 *
 * Contains character data fields, as well as access methods.
 *
 * @author Stefan Brus
 *
 */

public class Character extends BaseObject {

    /**
     * The character's year of birth
     */

    private int yearOfBirth;

    /**
     * The character's place of birth
     */

    private Location placeOfBirth;

    /**
     * The character's background story
     */

    private String background;

    /**
     * Constructor
     */

    public Character () {
        super("");

        this.yearOfBirth = 0;
        this.placeOfBirth = null;
        this.background = "";
    }

    /**
     * Get the year of birth
     *
     * @return The year of birth
     */

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    /**
     * Set the year of birth
     *
     * @param yearOfBirth The new year of birth
     */

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Get the place of birth
     *
     * @return The place of birth
     */

    public Location getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    /**
     * Set the place of birth
     *
     * @param placeOfBirth The new place of birth
     */

    public void setPlaceOfBirth(Location placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * Get the background
     *
     * @return The background
     */

    public String getBackground() {
        return this.background;
    }

    /**
     * Set the background
     *
     * @param background The new background
     */

    public void setBackground(String background) {
        this.background = background;
    }
}
