package myJavaTraining.projects.surpriseGenerator;

public interface IBag {

	// adds a surprise in the bag
	void put(ISurprise newSurprise);

	// adds an array of surprises in the bag
	void putMore(ISurprise[] newSurprises);

	// adds all the surprises from another IBag
	void putFromBag(IBag bagOfSurprises);

	// removes a surprise from the bag and returns it
	ISurprise takeOut();

	// Checks if the bag is empty or not
	boolean isEmpty();

	// Returns the number of surprises
	int size();
	

}
