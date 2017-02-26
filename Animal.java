/*
 * Name: Ross Singleton
 * Student number: C1615528
 */

/*
 * A class to represent a number of instances of a zoo animal.
 */
public class Animal {
    private final String animalName;
    private int inTotalNumAnimals;

	/*
	 * Constructor method for creating an animal with a given name
	 * and number of  animal instances.
	 * This constructor checks that the total number of instances argument is 
	 * valid; i.e., the number of animals should be 1 or more. 
	 * If not valid, the constructor will throw an IllegalArgumentException with
	 * an appropriate error message.
	 */
	public Animal( String inName, int inTotalNumAnimals ) {
		animalName = inName;
		this.inTotalNumAnimals = inTotalNumAnimals;
	}

	/*
	 * An accessor method that returns the animals name.
	 */
	public String getName() {
		// to be completed
	}

	/*
	 * An accessor method that returns the total number of instances of this animal.
	 * This should count both animal on loan to other collections and returned animals from other collections.
	 */ 
	public int getTotalAnimals() {
		// to be completed
	}

	/*
	 * Returns the number of instances of the animal that are available
	 * (i.e., not on loan to another collection).
	 */
	public int getAvailableAnimals() {
		// to be completed
	}

	/*
	 * Mark one of the instances of this animal as on loan to another collection.
	 * If there are no available instances to loan to another collection, then this method should 
	 * throw an IllegalStateException with an appropriate error message.
	 */
	public void loanAnimal() {
		// to be completed
	}

	/*
	 * Mark one of the instances of this animal as returned from another collection.
	 * If none of the instances of this animal are on loan to other collections, this method
	 * should throw an IllegalStateException with an appropriate error message.
	 */
	public void returnAnimal() {
		// to be completed
	}
}


