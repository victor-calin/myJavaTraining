package myJavaTraining.projects.fantasyWorld;
import java.util.ArrayList;

public class LordOfJava {
	private Parameters parameters;
	private Cohord<Dragon> dragons = new Cohord<>();
	private Cohord<Warg> wargs = new Cohord<>();
	private Cohord<Mumakil> mumakils = new Cohord<>();
	
	public LordOfJava(String OS, String gamePATH, String credentials, int noLives) {
		this.parameters = new Parameters(OS, gamePATH, credentials, noLives);
	}
	
	public void addCreature(Creature creature, String adress) {
		if(creature instanceof Dragon) {
			dragons.addNewCitizen(adress, (Dragon) creature);
		} else if(creature instanceof Warg) {
			wargs.addNewCitizen(adress, (Warg) creature);
		} else if(creature instanceof Mumakil) {
			mumakils.addNewCitizen(adress, (Mumakil) creature);
		} else {
			throw new IllegalArgumentException("Creture type unknown " + creature.getClass().getName());
		}
	}
	
	public int battleDragonsWargs() {
		if(dragons.size() < wargs.size()) {
			return -1;
		} else if(dragons.size() > wargs.size()) {
			return 1;
		} else {
			return equalFight();
		}
	}
	
	private int equalFight() {
		ArrayList<Dragon> dragonArmy = dragons.getAllCitizensToFight();
		ArrayList<Warg> wargArmy = wargs.getAllCitizensToFight();
		int score = 0;
		
		for(int i=0; i<dragons.size(); i++) {
			int individualDuel = dragonArmy.get(i).compareTo(wargArmy.get(i));
			
			score += individualDuel > 0 ? 1 : (individualDuel < 0 ? -1 : 0);
		}
		return score;
	}
	
	@Override
	public String toString() {
		return "" + parameters + "\n" + dragons + "\n" + wargs + "\n" + mumakils;
	}
	
	

}
