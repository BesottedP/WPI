import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Examples {

    PetRescue pr;
    LinkedList<Integer>oneBirdWeight = new LinkedList<Integer>();  

    public Examples(){
        oneBirdWeight.add(10); // 10oz
    }

    @Test
    public void testBirdWeightsEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals(0, pr.biggestBird()); // label text (optional), expected value, actual/check value
    }

    @Test
    public void testBirdWeights1(){
        pr = new PetRescue(oneBirdWeight, new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals(10, pr.biggestBird()); // label text (optional), expected value, actual/check value
    }

    @Test
    public void testBirdWeights3(){
        LinkedList<Integer> someBirdWeights = new LinkedList<Integer>();
        someBirdWeights.add(4);  
        someBirdWeights.add(10);  
        someBirdWeights.add(14);  
        pr = new PetRescue(someBirdWeights, new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals(14, pr.biggestBird()); // label text (optional), expected value, actual/check value
    }

    @Test
    public void bestowHonorTitle(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.bestowHonor("Dr.", "");
        assertEquals("Dr. Henry", pr.petOfTheMonth);
     } 

     @Test
    public void bestowHonorCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.bestowHonor("", "MD");
        assertEquals("Henry, MD", pr.petOfTheMonth);
     } 

     @Test
    public void bestowHonorFull(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.bestowHonor("Dr.", "");
        pr.bestowHonor("", "MD");
        assertEquals("Dr. Henry, MD", pr.petOfTheMonth );
     } 

      @Test
    public void bestowHonorMany(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.bestowHonor("Dr.", "");
        pr.bestowHonor("Capt.", "");
        pr.bestowHonor("", "PHD");
        pr.bestowHonor("", "MD");
        assertEquals("Capt. Dr. Henry, PHD MD", pr.petOfTheMonth);
     } 


      @Test
    public void bestowHonorNone(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.bestowHonor("", "");
        assertEquals("Henry", pr.petOfTheMonth);
     }

       @Test
    public void bestowHonorNoPet(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("", "");
        assertEquals("", pr.petOfTheMonth);
     }

        @Test
    public void bestowHonorNoPetHonored(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("Dr.", "PHD");
        assertEquals("Dr. , PHD", pr.petOfTheMonth);
     }

    @Test
    public void closestToNone(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        assertEquals("Conspiciously Catless", pr.closestTo(0, 0));
     }

     @Test
     public void closestToOne(){
        LinkedList<Coord> catCoord = new LinkedList<Coord>();
        catCoord.add(new Coord("Wilbur", 5, 2));
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", catCoord);
        assertEquals("Wilbur", pr.closestTo(0, 0));
     }

     @Test
     public void closestToThree(){
        LinkedList<Coord> catCoord = new LinkedList<Coord>();
        catCoord.add(new Coord("Steven", 1, 2));
        catCoord.add(new Coord("Wilbur", 5, 2));
        catCoord.add(new Coord("Theodore", -4, -3));
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", catCoord);
        assertEquals("Steven", pr.closestTo(0, 0));
     }

     @Test
     public void inHumanYears0(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        assertEquals(new LinkedList<Integer>(), pr.inHumanYears());
     }

     @Test
     public void inHumanYears3(){
        LinkedList<Integer> dogAge = new LinkedList<Integer>();
        dogAge.add(5);
        dogAge.add(1);
        dogAge.add(3);
        LinkedList<Integer> humanAge = new LinkedList<Integer>();
        humanAge.add(35);
        humanAge.add(7);
        humanAge.add(21);
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), dogAge, "Henry", new LinkedList<Coord>());
        assertEquals(humanAge, pr.inHumanYears());
     }

     @Test
     public void feedChinchillasAdd(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        assertEquals("Chinchilla: 6 pellets, 4 hay", pr.feedChinchillas(6, 4));
     }

     @Test
     public void feedChinchillasAddSubtract(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.feedChinchillas(10, 5);
        assertEquals("Chinchilla: 4 pellets, 1 hay", pr.feedChinchillas(-6, -4));
     }

     @Test
     public void feedChinchillasSubtract(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.feedChinchillas(-10, -5);
        assertEquals("Chinchilla: unknown pellets, unknown hay", pr.feedChinchillas(-6, -4));
     }

     @Test
     public void feedChinchillasAddSubtractPerf(){
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        pr.feedChinchillas(10, 5);
        assertEquals("Chinchilla: 0 pellets, 0 hay", pr.feedChinchillas(-10, -5));
     }

     @Test
     public void calculateDistanceTestPositive(){
        Coord catCoordtest = new Coord("Wilbur", 5, 2);
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        assertEquals(pr.calculateDistance(catCoordtest, 1, 3), Math.sqrt(17), 0.001);
     }

     @Test
     public void calculateDistanceTestNegative(){
        Coord catCoordtest = new Coord("Wilbur", 5, 2);
        PetRescue pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Henry", new LinkedList<Coord>());
        assertEquals(pr.calculateDistance(catCoordtest, 1, 3), Math.sqrt(17), 0.001);
     }

}