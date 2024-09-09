/**
 * An abstract class representing a petable object.
 * Subclasses should extend this class to define specific types of petable objects.
 */
public abstract class PetableAbstract {
    /**
     * The name of the petable object.
     */
    public String name;

    /**
     * The age of the petable object.
     */
    public int age;

    /**
     * The weight of the petable object in ounces.
     */
    public int weight;

    /**
     * The 2D coordinates of the petable object's location.
     */
    public Coord2D location;

    /**
     * Get the name of the petable object.
     *
     * @return The name of the petable object.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the weight of the petable object in ounces.
     *
     * @return The weight of the petable object in ounces.
     */
    public int getWeightInOz() {
        return weight;
    }

    /**
     * Get the age of the petable object.
     *
     * @return The age of the petable object.
     */
    public int getAge() {
        return age;
    }
}
