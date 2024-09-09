/**
 * A class representing a cat as a petable object, extending the abstract class PetableAbstract.
 * It defines the characteristics and behavior of a cat pet.
 */
public class Cat extends PetableAbstract implements Petable {

    /**
     * Indicates whether the cat has been petted today.
     */
    public boolean petted;

    /**
     * Creates a Cat object with the specified characteristics.
     *
     * @param name           The name of the cat.
     * @param age            The age of the cat.
     * @param weightInOz     The weight of the cat in ounces.
     * @param location       The 2D coordinates of the cat's location.
     * @param hasBeenPetToday A boolean value indicating whether the cat has been petted today.
     */
    public Cat(String name, int age, int weightInOz, Coord2D location, boolean hasBeenPetToday) {
        this.name = name;
        this.age = age;
        weight = weightInOz;
        this.location = location;
        petted = hasBeenPetToday;
    }

    /**
     * Specifies how much of a particular food a cat pet will eat.
     *
     * @param foodLabel The type of food being asked.
     * @return The amount of food the cat will eat (0 if the cat does not eat that food).
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("cans")) {
            if (this.petted) {
                return 2;
            } else {
                return 1;
            }
        } else if (foodLabel.equals("treats")) {
            return 1 + (weight / 8);
        } else {
            return 0;
        }
    }
}
