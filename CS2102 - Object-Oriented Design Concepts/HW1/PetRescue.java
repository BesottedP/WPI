import java.util.LinkedList;

public class PetRescue implements PetRescueable {

    public LinkedList<Integer> birdWeights;
    public LinkedList<Integer> dogYears;
    public String petOfTheMonth;
    public LinkedList<Coord> catCoords;
    public int pellets = 0;
    public int hay = 0;

    public PetRescue(LinkedList<Integer> birdWeights, LinkedList<Integer> dogYears, String petOfTheMonth, LinkedList<Coord> catCoords) {
        this.birdWeights = birdWeights;
        this.dogYears = dogYears;
        this.petOfTheMonth = petOfTheMonth;
        this.catCoords = catCoords;
    }


    /**
     * Searches the birds in the pet rescue
     * @return the size of the biggest bird in oz or 0 if there are no birds
     */
    @Override
    public int biggestBird() {
        if (birdWeights.isEmpty()) {
            return 0;
        }
        int maxWeight = birdWeights.get(0);
        for (int weight : birdWeights) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        return maxWeight;
    }

    /**
     * Transforms the dog records in the pet rescue
     * @return a list of ages in the same order as the dog records, 
     *         but each age is converted into human years by multiplying by 7
     */
    @Override
    public LinkedList<Integer> inHumanYears() {
        LinkedList<Integer> humanAges = new LinkedList<>();
        for (int dogAge : this.dogYears) {
            humanAges.add(dogAge * 7);
        }
        return humanAges;
    }

    /**
     * Awards the pet of the month with a title and/or a credential for their accomplishments
     * @param title Can be a title like "Dr." or "Capt."
     *              or the empty string "" if no title to be added
     * @param credential a degree or honor including but not limited to "MD", "PhD", or "Esq."
     *                   or the empty string "" if no credential to be added
     * effects: modifies the name on record of the form "TITLE name, CREDENTIAL"
     * multiple space separated titles can be added with the newest first
     * multiple space separated credentials can be added after the comma with the newest last.
     */
    @Override
    public void bestowHonor(String title, String credential) {
        String name = this.petOfTheMonth;
        if(!title.isEmpty()){
            name = title + " " + name;
        }
        if (!credential.isEmpty() && !name.contains(",")) {
            name += ", " + credential;
        }
        else if (!credential.isEmpty() && name.contains(",")) {
            name += " " + credential;
        }
        petOfTheMonth = name;
    }

    /**
     * Adds positive or subtracts negative food from the pantry and then prints out a new label for the contents inside
     * assume the initial amount of pellets and hay should be 0
     * @param pellets the amount of pellets to add/subtract
     * @param hay the amount of hay to add/subtract
     * @return a string in the format "Chinchilla: # pellets, # hay"
     * If the storage of pellets or hay goes negative, reset them to 0, and replace # with "unknown"
     */
    @Override
    public String feedChinchillas(int pellets, int hay) {
        this.pellets += pellets;
        this.hay += hay;
        boolean pelletsDebt = false;
        boolean hayDebt = false;
        
        if (this.pellets < 0) {
            this.pellets = 0;
            pelletsDebt = true; 
        }
        
        if (this.hay < 0) {
            this.hay = 0;
            hayDebt = true;
        }

        if (pelletsDebt && hayDebt) {
            return "Chinchilla: unknown pellets, unknown hay";
        }
        else if (pelletsDebt) {
            return "Chinchilla: unknown pellets, " + this.hay + " hay";
        }
        else if (hayDebt) {
            return "Chinchilla: " + this.pellets + " pellets, unknown hay";
        }
         return "Chinchilla: " + this.pellets + " pellets, " + this.hay + " hay";
    }

    /**
     * Finds the closest cat in the rescue to some coordinate
     *
     * @param x the coordinate to find the closest to
     * @param y
     * @return the name of the cat if found or "Conspiciously Catless" if there are no cats.
     */
    @Override
    public String closestTo(int x, int y) {
        if (catCoords.isEmpty()) {
            return "Conspiciously Catless";
        }

        String closestCatName = catCoords.get(0).name;
        double minDistance = calculateDistance(catCoords.get(0), x, y);

        for (Coord cat : catCoords) {
            double distance = calculateDistance(cat, x, y);
            if (distance < minDistance) {
                minDistance = distance;
                closestCatName = cat.name;
            }
        }

        return closestCatName;
    }

    public double calculateDistance(Coord cat, int x, int y){
        return (double)Math.sqrt(Math.pow((cat.x-x), 2) + Math.pow(Math.abs(cat.y-y), 2));
    }
}
