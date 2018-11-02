package myJavaTraining.projects.surpriseGenerator;

public class App {
	
	public static void main(String[] args) {
		//creating 6 occasions for giving surprises using different bags and celebrating actions
		GiveSurpriseAndApplause graduationDay = new GiveSurpriseAndApplause("fifo", 3);
		GiveSurpriseAndSing birthDay = new GiveSurpriseAndSing("lifo", 3);
		GiveSurpriseAndHug santaClause = new GiveSurpriseAndHug("random", 3);
		GiveSurpriseAndApplause secretSanta = new GiveSurpriseAndApplause("random", 3);
		GiveSurpriseAndSing christmasCarol = new GiveSurpriseAndSing("fifo", 3);
		GiveSurpriseAndHug liberationDay = new GiveSurpriseAndHug("lifo", 3);
		
		//collecting surprises and put them in the bags
		graduationDay.put(GatherSurprises.gather());
		birthDay.putMore(GatherSurprises.gather(2));
		santaClause.putMore(GatherSurprises.gather(3));
		secretSanta.putMore(GatherSurprises.gather(2));
		christmasCarol.putMore(GatherSurprises.gather(4));
		liberationDay.put(GatherSurprises.gather());
		
		//giving surprises & enjoy
		graduationDay.giveWithPassion(); //give 1 surprise and applaud
		birthDay.giveWithPassion(); //give 2 surprises and sing
		santaClause.giveWithPassion(); //give 3 surprise and hug
		secretSanta.giveWithPassion(); //give 2 surprises and applaud
		christmasCarol.giveWithPassion(); //give 4 surprises and sing
		liberationDay.giveWithPassion(); //give 1 surprise and hug		
	}
}

