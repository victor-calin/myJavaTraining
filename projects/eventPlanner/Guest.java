package myJavaTraining.projects.eventPlanner;

import java.io.Serializable;


public class Guest implements Serializable {
	
	private static final long serialVersionUID = -5916285181102646497L;
	private String nume;
	private String prenume;
	private String email;
	private String telefon;

	public Guest(String nume, String prenume, String email, String telefon) {
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.telefon = telefon;
	}

	public boolean isEqualTo(Guest g) {
		if (email.equalsIgnoreCase(g.email)) {
			return true;
		}
		return false;
	}

	public boolean isEqualByName(String nume, String prenume) {
		return nume.equalsIgnoreCase(this.nume) && 
				prenume.equalsIgnoreCase(this.prenume);
	}

	public boolean isEqualByEmail(String email) {
		return this.email.equalsIgnoreCase(email);
	}

	public boolean isEqualByPhone(String telefon) {
		return this.telefon.equalsIgnoreCase(telefon);
	}

	public boolean updateField(String nume, String prenume, 
			String email, String telefon) {
		if (nume != null) {
			this.nume = nume;
			return true;
		}
		if (prenume != null) {
			this.prenume = prenume;
			return true;
		}
		if (email != null) {
			this.email = email;
			return true;
		}
		if (telefon != null) {
			this.telefon = telefon;
			return true;
		}
		System.out.println("Error: An error occured in 'Guest'," + 
				" method 'updateField(...)'");
		return false; // Error Code
	}

	public boolean smartSearch(String token) {
		if (this.nume.toLowerCase().indexOf(token) >= 0 ||
				this.prenume.toLowerCase().indexOf(token) >= 0 ||
				this.email.toLowerCase().indexOf(token) >= 0 ||
				this.telefon.toLowerCase().indexOf(token) >= 0) {
			return true;
		}
		return false;
	}

	public String describe() {
		return "Nume: " + this.nume + " " + this.prenume + ", Email: "
				+ this.email + ", Telefon: " + this.telefon; 
	}

	public void notifyParticipation() {
		System.out.println("["+ this.nume + " " + this.prenume + 
				"] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
	}

	public void notifyWaitingList(int orderNo) {
		System.out.println("["+ this.nume + " " + this.prenume
				+ "] Te-ai inscris cu succes in lista de asteptare "
				+ "si ai primit numarul de ordine " + orderNo
				+ ". Te vom notifica daca un loc devine disponibil.");
	}
}
