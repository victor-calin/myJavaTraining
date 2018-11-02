package myJavaTraining.projects.fantasyWorld;

public interface ICreature {
	String getNickname();
	void setNickname(String nickname);
	void updateScore(int amount) throws NumberFormatException;
	void powerUp(double stamina, double speed, int agility);
}
