package myJavaTraining.projects.fantasyWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Cohord<C extends Creature> {
	private Map<String, C> citizen = new HashMap<>();
		
	public Map<String, C> getCitizen() {
		return citizen;
	}

	public void setCitizen(Map<String, C> citizen) {
		this.citizen = citizen;
	}

	public int size() {
		return citizen.size();
	}
	
	public Creature getCitizenAt(String adress) {
		return this.citizen.get(adress);
	}
	
	public boolean isEmpty() {
		return this.citizen.isEmpty();
	}
	
	public void addNewCitizen(String adress, C creature) {
		this.citizen.put(adress, creature);
	}
	
	public ArrayList<C> getAllCitizensToFight() {
		ArrayList<C> allAligned = new ArrayList<>(citizen.values());
		Collections.sort(allAligned);
		return allAligned;
	}
	
	@Override
	public String toString() {
		ArrayList<C> allAligned = getAllCitizensToFight();
		String ret = "";
		for(C creature : allAligned) {
			ret += creature + "\n";
		}
		return ret;
		
	}
}
