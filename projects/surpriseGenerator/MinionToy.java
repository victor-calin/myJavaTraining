package myJavaTraining.projects.surpriseGenerator;

public class MinionToy implements ISurprise {
	//fields
	private static String[] minionType = {"Dave", "Carl", "Kevin", "Struard", "Jerry", "Tim"};
	private static int nextMinion;
	private String minion;

	//constructor
	private MinionToy(String minion) {
		this.minion = minion;
	}

	@Override
	public void enjoy() {
		System.out.println("Woow! I've got " + this.minion + " the minion!");
	}

	public static MinionToy generate() {
		MinionToy minionSurprise = new MinionToy(minionType[nextMinion]);
		nextMinion++;

		if(nextMinion > 5) {
			nextMinion = 0;
		}

		return minionSurprise;
	}

}
