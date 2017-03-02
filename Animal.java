/*
 * Name: Ross Singleton
 * Student number: C1615528
 */

/*
 * A class to represent a number of instances of a zoo animal.
 */
public class Animal {
    private String animalName;
    private int totalAnimals;
    private int loanTotal;

	/*
	 * Constructor method for creating an animal with a given name
	 * and number of  animal instances.
	 * This constructor checks that the total number of instances argument is 
	 * valid; i.e., the number of animals should be 1 or more. 
	 * If not valid, the constructor will throw an IllegalArgumentException with
	 * an appropriate error message.
	 */
	public Animal( String inName, int inTotalNumAnimals ) {
		if (inTotalNumAnimals < 1) {
			throw new IllegalArgumentException("Error, number of animals is less than 1");
		}

		this.animalName = inName;
		this.totalAnimals = inTotalNumAnimals;
		this.loanTotal = 0;
	}

	/*
	 * An accessor method that returns the animals name.
	 */
	public String getName() {
		return animalName;
	}

	/*
	 * An accessor method that returns the total number of instances of this animal.
	 * This should count both animal on loan to other collections and returned animals from other collections.
	 */ 
	public int getTotalAnimals() {
		return totalAnimals;
	}

	/*
	 * Returns the number of instances of the animal that are available
	 * (i.e., not on loan to another collection).
	 */
	public int getAvailableAnimals() {
		return totalAnimals - loanTotal;
	}

	/*
	 * Mark one of the instances of this animal as on loan to another collection.
	 * If there are no available instances to loan to another collection, then this method should 
	 * throw an IllegalStateException with an appropriate error message.
	 */
	public void loanAnimal() {
		if (getAvailableAnimals() < 1) {
			throw new IllegalStateException("Error, no animals to loan");
		}

		loanTotal = loanTotal + 1;
	}

	/*
	 * Mark one of the instances of this animal as returned from another collection.
	 * If none of the instances of this animal are on loan to other collections, this method
	 * should throw an IllegalStateException with an appropriate error message.
	 */
	public void returnAnimal() {
		if (loanTotal < 1) {
			throw new IllegalStateException("Error, no animals on loan");
		}

		loanTotal = loanTotal - 1;
	}
}


