package myJavaTraining.projects.fantasyWorld;

public abstract class Creature implements Comparable<Creature>, ICreature {
	private Abilities abilities;
	private String nickname;
	private long score;

	public Creature(double stamina, double speed, int agility, String nickname, long score) {
		this.abilities = new Abilities(stamina, speed, agility);
		this.nickname = nickname;
		this.score = score;
	}

	public Abilities getAbilities() { return this.abilities; }
	public void setAbilities(Abilities abilities) { this.abilities = abilities; }
	public String getNickname() { return this.nickname; }
	public void setNickname(String nickname) { this.nickname = nickname; }

	public void updateScore(int amount) throws NumberFormatException {
		if(amount <= 0) {
			throw new NumberFormatException("Expecting positive bonus value, got: <" + amount +">");
		}
		score += amount;
	}

	public void powerUp(double stamina, double speed, int agility) {
		this.abilities.update(stamina, speed, agility);		
	}

	@Override
	public String toString() {
		return "Nickname: " + this.nickname +
				"\nScore: " + this.score + 
				"\n" + this.abilities.toString();
	}

	@Override
	public int compareTo(Creature creature) {
		return this.abilities.compareTo(creature.abilities);
	}
}
