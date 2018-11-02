package myJavaTraining.projects.surpriseGenerator;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {

	public GiveSurpriseAndApplause(String bagType, int waitTime) {
		super(bagType, waitTime);
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
