package myJavaTraining.projects.surpriseGenerator;

import java.util.Random;

public class Candies implements ISurprise {
	//fields
	private static String[] candyTypes = {"macaron", "lollipop", "marshmallow", "bubblegum", "candy stick", "mini cake"};
	private String[] candies;

	//constructor
	private Candies(String candyType, int noOfCandies) {
		this.candies = new String[noOfCandies];
		for(int i=0; i<noOfCandies; i++) {
			this.candies[i] = candyType;
		}
	}

	@Override
	public void enjoy() {
		System.out.print("Yummy! I've got " + this.candies.length + " ");

		if (this.candies.length == 1) {
			System.out.print(this.candies[0] + "!"); //for single candy
		} else {
			System.out.print(this.candies[0] + "s !"); //for multiple candies
		}

		System.out.println();
	}

	public static Candies generate() {
		Random randomCandy = new Random();
		int candyType = randomCandy.nextInt(6);
		Random n = new Random();
		int noOfCandies = n.nextInt(2) + 1; //to avoid 0

		Candies candySurprise = new Candies(candyTypes[candyType], noOfCandies);
		return candySurprise;
	}

}
