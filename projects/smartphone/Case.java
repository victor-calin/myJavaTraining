package myJavaTraining.projects.smartphone;

public class Case {
	//fields
	private String caseColor;
	private String caseType; //leather, silicon etc
	
	//constructor
	public Case(String caseColor, String caseType) {
		this.caseColor = caseColor;
		this.caseType = caseType;
	}
	
	public String getCaseColor() {
		return this.caseColor;
	}
	
	public String getCaseType() {
		return this.caseType;
	}
	
	//methods
	public void pressPowerButton() {
		System.out.println("class Case: Power button pressed.");
	}

	public void pressVolumeUp() {
		System.out.println("class Case: Volume UP pressed.");
	}

	public void pressVolumeDown() {
		System.out.println("class Case: Volume DOWN pressed.");
	}

}
