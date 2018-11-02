package myJavaTraining.projects.fantasyWorld;


public class Warg extends Creature implements IByte {
	private double bytePower;

	public Warg(double stamina, double speed, int agility, String nickname, long score, double bytePower) {
		super(stamina, speed, agility, nickname, score);
		this.bytePower = bytePower;
	}
	
	@Override
	public double getBytePower() {
		return this.bytePower;
	}

	@Override
	public void powerUp(double stamina, double speed, int agility) {
		super.powerUp(stamina / 2, speed * 4, agility);		
	}

	@Override
	public String toString() {
		return super.toString() + "\nByte power: " + this.bytePower; 
	}
}


