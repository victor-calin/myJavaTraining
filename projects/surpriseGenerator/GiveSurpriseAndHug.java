package myJavaTraining.projects.surpriseGenerator;

import java.util.concurrent.TimeUnit;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {
	
	public GiveSurpriseAndHug(String bagType, int waitTime) {
		super(bagType, waitTime);
	}
	
	@Override
	public void give() {
		super.give();
		System.out.println("crowd: \"Warm wishes and a big hug!\"\n");
	}
	
	@Override
	public void giveAll() {
		while(this.bag.size() != 0) {
			super.give();
			System.out.println("crowd: \"Warm wishes and a big hug!\"");
			try {
				TimeUnit.SECONDS.sleep(this.waitTime); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	@Override
	public void giveWithPassion() {
		if(this.isEmpty()) {
			System.out.println("Looks like this bag is empty, let's wait for the next one.");
		
		} else if (this.bag.size() == 1) {
			this.give();
		
		} else {
			this.giveAll();
		}
	}
	
}
