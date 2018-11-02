package myJavaTraining.projects.fantasyWorld;

public class Dragon extends Creature implements IBurn {
	private double flamesPower;
	private int flySpeed;

	public Dragon(double stamina, double speed, int agility, String nickname, long score, double flamesPower, int flySpeed) {
		super(stamina, speed, agility, nickname, score);
		this.flamesPower = flamesPower;
		this.flySpeed = flySpeed;
	}

	@Override
	public double getFlamesPower() {
		return this.flamesPower;
	}

	@Override
	public int getFlyingSpeed() {
		return this.flySpeed;
	}

	@Override
	public void powerUp(double stamina, double speed, int agility) {
		super.powerUp(stamina * 2, speed / 2, agility * 3);	
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nFlames power: " + this.flamesPower +
			   "\nFly speed: " + this.flySpeed;
	}


}
