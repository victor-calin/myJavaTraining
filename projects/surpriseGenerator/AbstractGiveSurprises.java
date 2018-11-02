package myJavaTraining.projects.surpriseGenerator;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
	//fields
	protected IBag bag;
	protected int waitTime;


	//constructor
	public AbstractGiveSurprises(String bagType, int waitTime) {
		this.bag = new BagFactory().makeBag(bagType);
		this.waitTime = waitTime;
	}
	
	public void put(ISurprise newSurprise) {
		this.bag.put(newSurprise);
	}

	public void putMore(ISurprise[] newSurprises) {
		this.bag.putMore(newSurprises);
	}

	public void give() {
		System.out.print("surprise: ");
		this.bag.takeOut().enjoy();
		this.giveWithPassion();
	}

	public void giveAll() {
		while(this.bag.size() != 0) {
			this.give();

			try {
				TimeUnit.SECONDS.sleep(this.waitTime); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isEmpty() {
		if(this.bag.isEmpty()) {
			return true;
		}
		return false;
	}

	protected abstract void giveWithPassion();


}
