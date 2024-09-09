/**
 * A class representing a bird as a petable object, extending the abstract class PetableAbstract.
 * It defines the characteristics and behavior of a bird pet.
 */
public class Bird extends PetableAbstract implements Petable {

    /**
     * Indicates whether the bird's wings are clipped.
     */
    public boolean clipped;

    /**
     * Creates a Bird object with the specified characteristics.
     * @param name           The name of the bird.
     * @param age            The age of the bird.
     * @param weightInOz     The weight of the bird in ounces.
     * @param location       The 2D coordinates of the bird's location.
     * @param wingsClipped   A boolean value indicating whether the bird's wings are clipped.
     */
    public Bird(String name, int age, int weightInOz, Coord2D location, boolean wingsClipped) {
        this.name = name;
        this.age = age;
        weight = weightInOz;
        this.location = location;
        clipped = wingsClipped;
    }

    /**
     * Checks whether the bird's wings are clipped.
     * @return true if the bird's wings are clipped; false otherwise.
     */
    public boolean isClipped() {
        return clipped;
    }

    /**
     * Specifies how much of a particular food a bird pet will eat.
     * @param foodLabel The type of food being asked.
     * @return The amount of food the bird will eat (0 if the bird does not eat that food).
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("seeds")) {
            return 1;
        }
        return 0;
    }
}
