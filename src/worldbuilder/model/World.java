package worldbuilder.model;

import java.util.Collection;
import java.util.HashMap;

import worldbuilder.model.characters.Character;
import worldbuilder.model.locations.Location;

/**
 * This class contains all the world's objects.
 *
 * Implemented as a singleton
 *
 * @author Stefan Brus
 *
 */

public class World {

    /**
     * Singleton instance
     */

    private static World instance;

    /**
     * The world's locations, mapped to their names
     */

    private HashMap<String, Location> locations;

    /**
     * The world's characteres, mapped to their names
     */

    private HashMap<String, Character> characters;

    /**
     * Constructor
     *
     * Private, use singleton instance method
     */

    private World() {
        this.locations = new HashMap<String, Location>();
        this.characters = new HashMap<String, Character>();
    }

    /**
     * Static singleton instance method
     *
     * @return The singleton instance
     */

    public static World instance() {
        if (instance == null) {
            instance = new World();
        }

        return instance;
    }

    /**
     * Store a location in the world
     *
     * @param loc The location
     */

    public void putLocation(Location loc) {
        this.locations.put(loc.getName(), loc);
    }

    /**
     * Store a character in the world
     *
     * @param chr The character
     */

    public void putCharacter(Character chr) {
        this.characters.put(chr.getName(), chr);
    }

    /**
     * Get a location
     *
     * @param name The name of the location
     * @return The location
     */

    public Location getLocation(String name) {
        return this.locations.get(name);
    }

    /**
     * Get a character
     *
     * @param name The name of the character
     * @return The character
     */

    public Character getCharacter(String name) {
        return this.characters.get(name);
    }

    /**
     * Get all locations
     *
     * @return The locations
     */

    public Collection<Location> getLocations() {
        return this.locations.values();
    }

    /**
     * Get all characters
     *
     * @return The characters
     */

    public Collection<Character> getCharacters() {
        return this.characters.values();
    }

    /**
     * Remove the given location
     *
     * @param name The name of the location to remove
     */

    public void removeLocation(String name) {
        this.locations.remove(name);
    }

    /**
     * Remove the given character
     *
     * @param name The name of the character to remove
     */

    public void removeCharacter(String name) {
        this.characters.remove(name);
    }
}
