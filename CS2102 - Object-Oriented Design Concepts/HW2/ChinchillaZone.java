import java.util.LinkedList;

/**
 * A class representing a zone for chinchillas that extends the abstract class ZoneableAbstract.
 * It allows for the management of chinchilla pets and their related operations.
 */

public class ChinchillaZone extends ZoneableAbstract implements Zoneable{
    /**
     * The list of chinchilla pets in the zone.
     */
    public LinkedList<Chinchilla> chinchillas;
    /**
     * The current stock of pellets in the pantry for chinchilla pets.
     */
    public int pellets;
    /**
     * The current stock of hay in the pantry for chinchilla pets.
     */
    public int hay;

    /**
     * Creates a ChinchillaZone with a list of chinchillas and initializes the pellets and hay stock to 0.
     *
     * @param chinchillas A linked list of Chinchilla objects to be placed in the zone.
     */
    public ChinchillaZone(LinkedList<Chinchilla> chinchillas){
        this.chinchillas = chinchillas;
        pellets = 0;
        hay = 0;
    }

    /**
     * Retrieves the list of chinchilla pets in the zone.
     *
     * @return A linked list of Chinchilla objects in the zone.
     */
    @Override
    public LinkedList<? extends Petable> getPets() {
        return chinchillas;
    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     *         or -1 if that pet name is not in this zone
     */
    @Override
    public int inHumanYears(String petName) {
        for (Chinchilla chinchilla : chinchillas){
            if (chinchilla.getName().equals(petName)){
                return chinchilla.getAge() * 10;
            }
        }
        return -1;
    }

    /**
     *
     * @param foodName The name of a food item expected to be stocked in this zone's pantry
     * @param foodAmt A non-negative number (>= 0) representing how much of that food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if (foodName == "pellets"){
            pellets += foodAmt;
        }
        if (foodName == "hay"){
            hay += foodAmt;
        }
        return this;
    }

    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for "unknown" logic).
     */
    @Override
    public Zoneable feedZone() {
        for (Chinchilla chinchilla : chinchillas){
            pellets -= chinchilla.eats("pellets");
            hay -= chinchilla.eats("hay");
        }
        if (pellets < 0){
            pellets = 0;
        }
        if (hay < 0){
            hay = 0;
        }
        return this;
    }

    /**
     * Returns the stock of the pantry for the zone
     * @return a string printing out the pantry in the format of "Animal: # food1, # food2, ...etc"
     */
    @Override
    public String getPantryLabel() {
        return "Chinchilla: " + pellets + " pellets, " + hay + " hay";
    }

    /**
     * Gets the name of the pet that is closest to the given 3D coord
     *
     * @param x the 3D coord that only has the location information
     * @param y
     * @return the name of the pet closest to that coord
     * In the result of a tie, you may return any one
     * assume the "z" coordinate we are using is 0 by default
     * return "No Pets Found" if there are no pets in the zone.
     */
    @Override
    public String closestPet(int x, int y) {
        if(chinchillas.size() == 0){
            return "No Pets Found";
        }
        Chinchilla closest = chinchillas.get(0);
        for (Chinchilla chinchilla : chinchillas){
            if(Math.sqrt(Math.pow((chinchilla.location.x-x), 2) + Math.pow(Math.abs(chinchilla.location.y-y), 2)) <
                Math.sqrt(Math.pow((closest.location.x-x), 2) + Math.pow(Math.abs(closest.location.y-y), 2))){
                    closest = chinchilla;
                }
        }
        return closest.getName();
    }
    
}
