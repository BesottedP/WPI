import java.util.LinkedList;

/**
 * An abstract class representing a zone that can contain petable objects.
 * Subclasses should implement the methods to manage and retrieve petable objects.
 */

public abstract class ZoneableAbstract {

    /** retrieve the list of petable objects from the subclass 
  * @return a linked list of objects that implement Petable
  */   
  public abstract LinkedList<? extends Petable> getPets();

    /**
     * Produces the number of pets in the zone
     * @return the number of total pets in the zone
     */
    public int petsInZone() {
        return this.getPets().size();
    }

    /**
     * finds and produces the fattest animal available
     * @return the heaviest pet (the one with the greatest weight according to its getWeightInOz() method)
     * @return null if there are no pets
     */
    public Petable heaviestPet() {
        if (this.getPets().isEmpty()){
            return null;
        }
        Petable heaviest = this.getPets().get(0);
        for (Petable pet : this.getPets()) {
            if (pet.getWeightInOz() > heaviest.getWeightInOz()){
                heaviest = pet;
            }
        }
        return heaviest;
    }

    /**
     * Fetch me that pet!
     * @param petName the pet to look up in the zone, you may assume the pet is in the zone
     * @return the pet with that name or null if pet is not in the zone
     */
    public Petable getPet(String petName) {
        for (Petable pet : this.getPets()) {
            if (pet.getName().equals(petName)){
                return pet;
            }
        }
        return null;
    }

}
