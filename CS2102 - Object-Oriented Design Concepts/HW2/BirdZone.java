import java.util.LinkedList;

/**
 * A class representing a zone for birds that extends the abstract class ZoneableAbstract.
 * It allows for the management of bird pets and their related operations.
 */

public class BirdZone extends ZoneableAbstract implements Zoneable{
    /**
     * The list of bird pets in the zone.
     */
    public LinkedList<Bird> birds;
    /**
     * The current stock of seeds in the pantry for bird pets.
     */
    public int seeds;

    /**
     * Creates a BirdZone with a list of birds and initializes the seed stock to 0.
     *
     * @param birds A linked list of Bird objects to be placed in the zone.
     */
    public BirdZone(LinkedList<Bird> birds){
        this.birds = birds;
        seeds = 0;
    }

    /**
     * Retrieves the list of bird pets in the zone.
     *
     * @return A linked list of Bird objects in the zone.
     */
    @Override
    public LinkedList<? extends Petable> getPets() {
        return birds;
    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     *         or -1 if that pet name is not in this zone
     */
    @Override
    public int inHumanYears(String petName) {
        for (Bird bird : birds){
            if (bird.getName().equals(petName)){
                return bird.getAge() * 9;
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
        if (foodName == "seeds"){
            seeds += foodAmt;
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
        for (Bird bird : birds){
            seeds -= bird.eats("seeds");
        }
        if (seeds < 0){
            seeds = 0;
        }
        return this;
    }

    /**
     * Returns the stock of the pantry for the zone
     * @return a string printing out the pantry in the format of "Animal: # food1, # food2, ...etc"
     */
    @Override
    public String getPantryLabel() {
        return "Bird: " + seeds + " seeds";
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
        if(birds.size() == 0){
            return "No Pets Found";
        }
        Bird closest = birds.get(0);
        for (Bird bird : birds){
            int zCoord = 2;
            if (bird.isClipped()){
                zCoord = 0;
            }
            if(Math.sqrt(Math.pow((bird.location.x-x), 2) + Math.pow(Math.abs(bird.location.y-y), 2) + Math.pow(Math.abs(zCoord), 2)) <
                Math.sqrt(Math.pow((closest.location.x-x), 2) + Math.pow(Math.abs(closest.location.y-y), 2) + Math.pow(Math.abs(zCoord), 2))){
                    closest = bird;
                }
        }
        return closest.getName();
    }

    
}

