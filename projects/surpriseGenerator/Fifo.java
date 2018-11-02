package myJavaTraining.projects.surpriseGenerator;

import java.util.ArrayList;

public class Fifo implements IBag {
	private ArrayList<ISurprise> bag;
	
	public Fifo() {
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
		Fifo fifoObj = (Fifo)bagOfSurprises; //downcasting to access private fields
		for (int i=0; i<fifoObj.bag.size(); i++) {
			this.bag.add(fifoObj.bag.get(i)); //copy the surprise
		}
		fifoObj.bag.clear(); //empty the bagOfSurprises after all surprises were copied
	}

	// removes a surprise from the bag and returns it
	public ISurprise takeOut() {
		return this.bag.remove(0);
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
