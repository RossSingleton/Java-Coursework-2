/*
 * Name: Ross Singleton
 * Student number: C1615528
 */

/*
 * A class to represent a zoo.
 * A zoo can either have unlimited animal capacity or limited animal capacity.
 * For limited capacity zoos, animals on loan to other zoo collections still count towards the 
 * capacity (there must be space reserved for when an animal is returned).
 */
import java.util.*;

public class Zoo {
    //Define a hashmap
    private HashMap<String, Animal> zooAnimals;
    private int zooTotal;   

    /*
     * Construct a Library with unlimited capacity.
     */ 
    public Zoo() {
		zooAnimals = new HashMap<String, Animal>();

        //zooTotal will never be -1 therefore capacity is infinite.
        this.zooTotal = -1;
    }

    /*
     * Construct a Library with limited capacity.
     */ 
    public Zoo( int inCapacity ) {
		if (inCapacity <= 0) {
            throw new IllegalArgumentException("Error, invalid zoo capacity");
        }
        zooAnimals = new HashMap<String, Animal>();
            this.zooTotal = inCapacity;
    }
    
    public void addAnimal(Animal newAnimal) {
        //Checks if the Zoo is at capacity, will only add to the hashmap if not
        if (zooTotal == -1) {
            zooAnimals.put(newAnimal.getName().toLowerCase(), newAnimal);
        }
        else if (newAnimal.getAvailableAnimals() + this.numberAvailableAnimals() <= zooTotal) {
            zooAnimals.put(newAnimal.getName().toLowerCase(), newAnimal);
        }
        else {
            throw new IllegalStateException("Error, Zoo at capacity");
        }
    }

    public boolean hasAnimalWithName(String animalName) {
        for(String key: zooAnimals.keySet()) {
            if(animalName.toLowerCase().equals(key.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public Animal getAnimalWithName(String animalName) {
        if(zooAnimals.containsKey(animalName.toLowerCase())) {
            return zooAnimals.get(animalName.toLowerCase());
        }
        else { 
            return null;
        }
    }

    public int numberAvailableAnimals() {
        int animalTotal = 0;
        for(Animal animal: zooAnimals.values()) {
            animalTotal = animalTotal + animal.getAvailableAnimals();
        }
        return animalTotal;
    }
}


