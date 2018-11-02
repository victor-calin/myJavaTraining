package myJavaTraining.projects.surpriseGenerator;

import java.util.Random;
import java.util.ArrayList;

public class Arbitrary implements IBag {
	private ArrayList<ISurprise> bag;
	
	public Arbitrary() {
		this.bag = new ArrayList<ISurprise>();
	}

	// adds a surprise in the bag
	public void put(ISurprise newSurprise) {
		this.bag.add(newSurprise);
	}

	// adds an array of surprises in the bag
	public void putMore(ISurprise[] newSurprises) {
		if(newSurprises.length == 0) {
			return;
		} else {
			for(int i=0; i<newSurprises.length; i++) {
				this.bag.add(newSurprises[i]);
			}
		}
	}

	// adds all the surprises from another IBag
	public void putFromBag(IBag bagOfSurprises) {
		Arbitrary arbitraryObj = (Arbitrary)bagOfSurprises; //downcasting to access private fields
		for (int i=0; i<arbitraryObj.bag.size(); i++) {
			this.bag.add(arbitraryObj.bag.get(i)); //copy the surprise
		}
		arbitraryObj.bag.clear(); //empty the bagOfSurprises after all surprises were copied
	}

	// removes a surprise from the bag and returns it
	public ISurprise takeOut() {
		Random n = new Random();
		int toGive = n.nextInt(this.bag.size());
		return this.bag.remove(toGive);
	}

	// Checks if the bag is empty or not
	public boolean isEmpty() {
		if(this.bag.size() == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of surprises
	public int size() {
		return this.bag.size();
	}

}