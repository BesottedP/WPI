/**
 * A class representing a chinchilla as a petable object, extending the abstract class PetableAbstract.
 * It defines the characteristics and behavior of a chinchilla pet.
 */
public class Chinchilla extends PetableAbstract implements Petable {

    /**
     * The amount of dust bath residue in ounces.
     */
    public int residue;

    /**
     * Creates a Chinchilla object with the specified characteristics.
     *
     * @param name               The name of the chinchilla.
     * @param age                The age of the chinchilla.
     * @param weightInOz         The weight of the chinchilla in ounces.
     * @param location           The 2D coordinates of the chinchilla's location.
     * @param dustBathResidueInOz The amount of dust bath residue in ounces.
     */
    public Chinchilla(String name, int age, int weightInOz, Coord2D location, int dustBathResidueInOz) {
        this.name = name;
        this.age = age;
        weight = weightInOz;
        this.location = location;
        residue = dustBathResidueInOz;
    }

    /**
     * Overrides the getWeightInOz method to include the dust bath residue.
     *
     * @return The total weight of the chinchilla, including the dust bath residue, in ounces.
     */
    @Override
    public int getWeightInOz() {
        return weight + residue;
    }

    /**
     * Specifies how much of a particular food a chinchilla pet will eat.
     *
     * @param foodLabel The type of food being asked.
     * @return The amount of food the chinchilla will eat (0 if the chinchilla does not eat that food).
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("pellets")) {
            return 3;
        } else if (foodLabel.equals("hay")) {
            return 1;
        } else {
            return 0;
        }
    }
}
