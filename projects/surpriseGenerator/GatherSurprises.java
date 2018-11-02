package myJavaTraining.projects.surpriseGenerator;
import java.util.Random;

public final class GatherSurprises {

	private GatherSurprises() {} //to avoid instantiation

	public static ISurprise gather() {
		Random r = new Random();
		int randomSurprise = r.nextInt(3);

		switch(randomSurprise) {
		case 0:
			return FortuneCookie.generate();
		case 1:
			return Candies.generate();
		case 2:
			return MinionToy.generate();
		default:
			return MinionToy.generate(); //it never reaches this line
		}
	}

	public static ISurprise[] gather(int n) {
		ISurprise[] randomSurprises = new ISurprise[n];

		for (int i=0; i<n; i++) {
			randomSurprises[i] = GatherSurprises.gather(); 
		}
		return randomSurprises;
	}

}
