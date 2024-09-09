import java.util.LinkedList;

/**
 * A class representing a zone for cats that extends the abstract class ZoneableAbstract.
 * It allows for the management of cat pets and their related operations.
 */

public class CatZone extends ZoneableAbstract implements Zoneable {
    /**
     * The list of cat pets in the zone.
     */
    public LinkedList<Cat> cats;
    /**
     * The current stock of cans in the pantry for cat pets.
     */
    public int cans;
    /**
     * The current stock of treats in the pantry for cat pets.
     */
    public int treats;

    /**
     * Creates a CatZone with a list of cats and initializes the cans and treats stock to 0.
     *
     * @param cats A linked list of Cat objects to be placed in the zone.
     */
    public CatZone(LinkedList<Cat> cats){
        this.cats = cats;
        cans = 0;
        treats = 0;
    }

    /**
     * Retrieves the list of cat pets in the zone.
     *
     * @return A linked list of Cat objects in the zone.
     */
    @Override
    public LinkedList<? extends Petable> getPets() {
        return cats;
    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     *         or -1 if that pet name is not in this zone
     */
    @Override
    public int inHumanYears(String petName) {
        for (Cat cat : cats){
            if (cat.getName().equals(petName)){
                return cat.getAge() * 6;
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
        if (foodName == "cans"){
            cans += foodAmt;
        }
        if (foodName == "treats"){
            treats += foodAmt;
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
        for (Cat cat : cats){
            cans -= cat.eats("cans");
            treats -= cat.eats("treats");
        }
        if (cans < 0){
            cans = 0;
        }
        if (treats < 0){
            treats = 0;
        }
        return this;
    }

    /**
     * Returns the stock of the pantry for the zone
     * @return a string printing out the pantry in the format of "Animal: # food1, # food2, ...etc"
     */
    @Override
    public String getPantryLabel() {
        return "Cat: " + cans + " cans, " + treats + " treats";
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
        if(cats.size() == 0){
            return "No Pets Found";
        }
        Cat closest = cats.get(0);
        for (Cat cat : cats){
            if(Math.sqrt(Math.pow((cat.location.x-x), 2) + Math.pow(Math.abs(cat.location.y-y), 2)) <
                Math.sqrt(Math.pow((closest.location.x-x), 2) + Math.pow(Math.abs(closest.location.y-y), 2))){
                    closest = cat;
                }
        }
        return closest.getName();
    }
    
}
