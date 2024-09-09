import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Examples {

    public Examples(){

    }

    /* ANIMAL TESTS */

    @Test
    public void testBirdEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(1,b.eats("seeds"));
    }

    @Test
    public void testCatEatsYesPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),true);
        assertEquals(2,c.eats("cans"));
    }

    @Test
    public void testCatEatsNoPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),false);
        assertEquals(1,c.eats("cans"));
    }

    @Test
    public void testCatEatsTreatsBaby(){
        Cat c = new Cat("Kitten",4,6,new Coord2D(2,2),true);
        assertEquals(1,c.eats("treats"));
    }

    @Test
    public void testChinchillaEatsPellets(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(3,ch.eats("pellets"));
    }

    @Test
    public void testChinchillaEatsHay(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(1,ch.eats("hay"));
    }
   

    @Test
    public void animalGetName(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Aria", c.getName());
        assertEquals("Dusty", ch.getName());
    }

    @Test
    public void animalGetAge(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(4, b.getAge());
        assertEquals(4, c.getAge());
        assertEquals(4, ch.getAge());
    }

    @Test
    public void animalGetWeight(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(3, b.getWeightInOz());
        assertEquals(20, c.getWeightInOz());
        assertEquals(24, ch.getWeightInOz());
    }

    /** ZONE Tests */


    @Test
    public void ZoneTestPetsInZone3(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Red",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Orange",1,3,new Coord2D(2,2),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        cats.add(new Cat("Math",4,12,new Coord2D(2,2),false));
        cats.add(new Cat("c418",4,12,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));
        chinchillas.add(new Chinchilla("Musty",4,20,new Coord2D(0,0), 4));
        chinchillas.add(new Chinchilla("Crusty",4,20,new Coord2D(0,0), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(3, bz.petsInZone());
        assertEquals(3, cz.petsInZone());
        assertEquals(3, chz.petsInZone());
    }

    @Test
    public void ZoneTestPetsInZone1(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(1, bz.petsInZone());
        assertEquals(1, cz.petsInZone());
        assertEquals(1, chz.petsInZone());
    }

    @Test
    public void ZoneTestPetsInZone0(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(0, bz.petsInZone());
        assertEquals(0, cz.petsInZone());
        assertEquals(0, chz.petsInZone());
    }

    @Test
    public void ZoneTestHeaviest1(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Orange",1,8,new Coord2D(2,2),true));
        cats.add(new Cat("c418",4,19,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Crusty",4,20,new Coord2D(0,0), 8));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Orange", bz.heaviestPet().getName());
        assertEquals("c418", cz.heaviestPet().getName());
        assertEquals("Crusty", chz.heaviestPet().getName());
    }

    @Test
    public void ZoneTestHeaviest3(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,5,new Coord2D(2,2),true));
        birds.add(new Bird("Red",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Orange",1,8,new Coord2D(2,2),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        cats.add(new Cat("Math",4,10,new Coord2D(2,2),false));
        cats.add(new Cat("c418",4,19,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,22,new Coord2D(0,0), 4));
        chinchillas.add(new Chinchilla("Musty",4,23,new Coord2D(0,0), 4));
        chinchillas.add(new Chinchilla("Crusty",4,20,new Coord2D(0,0), 8));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Orange", bz.heaviestPet().getName());
        assertEquals("c418", cz.heaviestPet().getName());
        assertEquals("Crusty", chz.heaviestPet().getName());
    }

    @Test
    public void inHumanYearsTest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(9, bz.inHumanYears("Blue"));
        assertEquals(24, cz.inHumanYears("Aria"));
        assertEquals(40, chz.inHumanYears("Dusty"));
        assertEquals(-1, bz.inHumanYears("Dusty"));
        assertEquals(-1, cz.inHumanYears("Blue"));
        assertEquals(-1, chz.inHumanYears("Aria"));
    }

    @Test
    public void restockPetFoodTest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        bz.restockPetFood("seeds", 10).restockPetFood("seeds", 0);
        cz.restockPetFood("cans", 10).restockPetFood("cans", 0);
        cz.restockPetFood("treats", 10).restockPetFood("treats", 0);
        chz.restockPetFood("pellets", 10).restockPetFood("pellets", 0);
        chz.restockPetFood("hay", 10).restockPetFood("hay", 0);

        assertEquals("Bird: 10 seeds", bz.getPantryLabel());
        assertEquals("Cat: 10 cans, 10 treats", cz.getPantryLabel());
        assertEquals("Chinchilla: 10 pellets, 10 hay", chz.getPantryLabel());
    }

    @Test
    public void feedZoneTest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        bz.restockPetFood("seeds", 10).restockPetFood("seeds", 0);
        cz.restockPetFood("cans", 10).restockPetFood("cans", 0);
        cz.restockPetFood("treats", 10).restockPetFood("treats", 0);
        chz.restockPetFood("pellets", 10).restockPetFood("pellets", 0);
        chz.restockPetFood("hay", 10).restockPetFood("hay", 0);

        bz.feedZone();
        cz.feedZone();
        chz.feedZone();

        assertEquals("Bird: 9 seeds", bz.getPantryLabel());
        assertEquals("Cat: 9 cans, 8 treats", cz.getPantryLabel());
        assertEquals("Chinchilla: 7 pellets, 9 hay", chz.getPantryLabel());
    }

    @Test
    public void feedZoneTestBugged(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));

        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        chz.restockPetFood("pellets", 1).restockPetFood("pellets", 0);
        chz.restockPetFood("hay", 1).restockPetFood("hay", 0);

        chz.feedZone();

        assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
    }

    @Test
    public void getPetTest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        Bird b = new Bird("Blue",1,3,new Coord2D(2,2),true);
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),false);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        birds.add(b);
        cats.add(c);
        chinchillas.add(ch);
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(b, bz.getPet("Blue"));
        assertEquals(c, cz.getPet("Aria"));
        assertEquals(ch, chz.getPet("Dusty"));
        assertEquals(null, chz.getPet("Blue"));
    }

    @Test
    public void TestClosest0(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("No Pets Found", bz.closestPet(0,0));
        assertEquals("No Pets Found", cz.closestPet(0,0));
        assertEquals("No Pets Found", chz.closestPet(0,0));
    }

    @Test
    public void TestClosest1(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        cats.add(new Cat("Aria",4,12,new Coord2D(2,2),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4));
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Aria", cz.closestPet(0,0));
        assertEquals("Dusty", chz.closestPet(0,0));
    }

    @Test
    public void TestClosest3(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(0,5),true));
        birds.add(new Bird("Red",1,3,new Coord2D(5,0),true));
        birds.add(new Bird("Orange",1,3,new Coord2D(3,4),false));
        cats.add(new Cat("Aria",4,12,new Coord2D(0,5),false));
        cats.add(new Cat("Math",4,12,new Coord2D(5,0),false));
        cats.add(new Cat("c418",4,12,new Coord2D(1,1),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,5), 4));
        chinchillas.add(new Chinchilla("Musty",4,20,new Coord2D(5,0), 4));
        chinchillas.add(new Chinchilla("Crusty",4,20,new Coord2D(1,1), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Blue", bz.closestPet(0,0));
        assertEquals("c418", cz.closestPet(0,0));
        assertEquals("Crusty", chz.closestPet(0,0));
    }

    @Test
    public void birdZoneTestClosestClipped(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }

    @Test
    public void birdZoneTestClosestNotClipped(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),false));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }

    @Test
    public void totalPetsTest3(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(0,5),true));
        birds.add(new Bird("Red",1,3,new Coord2D(5,0),true));
        birds.add(new Bird("Orange",1,3,new Coord2D(1,1),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(0,5),false));
        cats.add(new Cat("Math",4,12,new Coord2D(5,0),false));
        cats.add(new Cat("c418",4,12,new Coord2D(1,1),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,5), 4));
        chinchillas.add(new Chinchilla("Musty",4,20,new Coord2D(5,0), 4));
        chinchillas.add(new Chinchilla("Crusty",4,20,new Coord2D(1,1), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals(9, sz.totalPets());
    }

    @Test
    public void totalPetsTest1(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(0,5),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(0,5),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,5), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals(3, sz.totalPets());
    }

    @Test
    public void totalPetsTest0(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals(0, sz.totalPets());
    }

    @Test
    public void getHeaviestPetTest3(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,4,new Coord2D(0,5),true));
        birds.add(new Bird("Red",1,3,new Coord2D(5,0),true));
        birds.add(new Bird("Orange",1,6,new Coord2D(1,1),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(0,5),false));
        cats.add(new Cat("Math",4,18,new Coord2D(5,0),false));
        cats.add(new Cat("c418",4,10,new Coord2D(1,1),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,5), 4));
        chinchillas.add(new Chinchilla("Musty",4,21,new Coord2D(5,0), 4));
        chinchillas.add(new Chinchilla("Crusty",4,28,new Coord2D(1,1), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals("Crusty", sz.getHeaviestPetsName());
    }

    @Test
    public void getHeaviestPetTest1(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        birds.add(new Bird("Blue",1,3,new Coord2D(0,5),true));
        cats.add(new Cat("Aria",4,12,new Coord2D(0,5),false));
        chinchillas.add(new Chinchilla("Dusty",4,20,new Coord2D(0,5), 4));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals("Dusty", sz.getHeaviestPetsName());
    }

    @Test
    public void getHeaviestPetTest0(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(bz);
        zones.add(cz);
        zones.add(chz);
        SuperPetRescue sz = new SuperPetRescue(zones);
        assertEquals(0, sz.totalPets());
    }
}