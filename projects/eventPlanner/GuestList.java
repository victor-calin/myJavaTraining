package myJavaTraining.projects.eventPlanner;

import java.io.Serializable;
import java.util.ArrayList;

public class GuestList implements Serializable {

	private static final long serialVersionUID = -2758187450433356180L;
	private int numberSeats;
	
	// helds both the participants and the
	// waitlist (starting with the numerSeats index)
	private ArrayList<Guest> participants;

	public GuestList(int numberSeats) {
		this.numberSeats = numberSeats;
		this.participants = new ArrayList<Guest>(this.numberSeats);
	}

	public int add(Guest guest) {
		if (find(guest)) {
			return -1;
		}

		this.participants.add(guest);
		if (this.participants.size() <= this.numberSeats) {
			guest.notifyParticipation();
			return 0;
		}

		int waitlistPosition = this.participants.size() - this.numberSeats;
		guest.notifyWaitingList(waitlistPosition);
		return waitlistPosition;
	}

	private boolean find(Guest guest) {
		for (int i=0; i<this.participants.size(); i++) {
			if (this.participants.get(i).isEqualTo(guest)) {
				return true;
			}
		}
		return false;
	}

	public int findGuestPosition(String[] fullName, 
			String email, String phoneNumber) {
		if (fullName != null) {
			return findGuestByName(fullName);
		}
		if (email != null) {
			return findGuestByEmail(email);
		}
		if (phoneNumber != null) {
			return findGuestByPhone(phoneNumber);
		}
		System.out.println("Error: An error occured in 'GuestList',"
				+ " method 'findGuestPosition(...)'");
		return -2; // Error Code
	}

	public boolean removeGuestByIndex(int index) {
		if (index < 0 || index >= this.participants.size()) {
			System.out.println("Error: Index out of bounds in 'GuestList',"
					+ " method 'removeGuestByIndex(...)'");
			return false;
		}

		if (index < this.numberSeats && this.participants.size() > this.numberSeats) {
			// we have to notify a lucky person from waitlist.
			//that person is on participants[numberSeats] position
			participants.get(this.numberSeats).notifyParticipation();
		}
		this.participants.remove(index);

		return true;
	}

	public Guest get(int index) {
		if (index < 0 || index >= this.participants.size()) {
			System.out.println("Error: Index out of bounds in 'GuestList'," 
					+ " method 'get(...)'");
			return null;
		}
		return participants.get(index);
	}

	public ArrayList<Guest> smartSearch(String token) {
		ArrayList<Guest> matches = new ArrayList<Guest>();
		for (int i=0; i<this.participants.size(); i++) {
			if (this.participants.get(i).smartSearch(token)) {
				matches.add(this.participants.get(i));
			}
		}
		return matches; 
	}

	public void printParticipants() {
		int total = Math.min(this.participants.size(), this.numberSeats);
		if (total == 0) {
			System.out.println("Niciun participant inscris...");
		} else {
			for (int i=0; i<total; i++) {
				System.out.println((i + 1) + ". " + this.participants.get(i).describe());
			}
		}
	}

	public void printWaitlist() {
		int total = this.participants.size() - this.numberSeats;
		if (total <= 0) {
			System.out.println("Lista de asteptare este goala...");
		} else {
			for (int i=this.numberSeats; i<this.participants.size(); i++) {
				System.out.println((i - this.numberSeats + 1) + ". "
						+ this.participants.get(i).describe());
			}
		}
	}

	public int availableNoSeats() {
		int availableSeats = this.numberSeats - this.participants.size(); 
		return availableSeats > 0 ? availableSeats : 0;
	}

	public int participantsNo() {
		return Math.min(this.numberSeats, this.participants.size()); 
	}

	public int waitlistSize() {
		int waitlistSize = this.participants.size() - this.numberSeats;
		return waitlistSize > 0 ? waitlistSize : 0;
	}

	public int interestedNo() {
		return this.participants.size();
	}

	private int findGuestByName(String[] fullName) {
		for (int i=0; i<this.participants.size(); i++) {
			if (this.participants.get(i).isEqualByName(fullName[0], fullName[1])) {
				return i;
			}
		}
		return -1;
	}

	private int findGuestByEmail(String email) {
		for (int i=0; i<this.participants.size(); i++) {
			if (this.participants.get(i).isEqualByEmail(email)) {
				return i;
			}
		}
		return -1;
	}

	private int findGuestByPhone(String phoneNumber) {
		for (int i=0; i<this.participants.size(); i++) {
			if (this.participants.get(i).isEqualByPhone(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}
}
