package myJavaTraining.projects.smartphone;

public class Smartphone extends Phone {
	//fields
	private Case theCase;

	//constructors
	public Smartphone(String phoneName, int noPixels, double screenWidth, double screenLength, double screenDepth, 
			String caseColor, String caseType, int speakerMaxVol, int micMaxVol) {
		super(phoneName, noPixels, screenWidth, screenLength, screenDepth, speakerMaxVol, micMaxVol);
		this.theCase = new Case(caseColor, caseType);
	}

	public Smartphone(String phoneName, int noPixels, double screenWidth, double screenLength, double screenDepth, 
			String caseColor, String caseType, int speakerMaxVol, int micMaxVol, int speakerCrtVol, int micCrtVol) {
		super(phoneName, noPixels, screenWidth, screenLength, screenDepth, speakerMaxVol, micMaxVol, speakerCrtVol, micCrtVol);
		this.theCase = new Case(caseColor, caseType);
	}

	//methods
	@Override
	public void pressVolumeUp() {
		this.theCase.pressVolumeUp();
		this.theSpeaker.increaseVolume();
	}
	
	@Override
	public void pressVolumeDown() {
		this.theCase.pressVolumeDown();
		this.theSpeaker.decreaseVolume();
	}

	public void setPixel(int pixelIndex, String color) {
		this.theScreen.setPixel(pixelIndex, color); //double delegation
	}

	public void colorScreen(String color) {
		this.theScreen.colorScreen(color); //double delegation
	}
	
	@Override
	public void increaseMicrophoneVolume() {
		this.theMicrophone.increaseVolume();
	}
	
	@Override
	public void decreaseMicrophoneVolume() {
		this.theMicrophone.decreaseVolume();
	}

	public void muteMicrophone() {
		this.theMicrophone.muteMicrophone();
	}

	public void setSilenceMode() {
		this.theSpeaker.setSilenceMode();
	}
	
	@Override
	public void openPhone() {
		this.theCase.pressPowerButton();
	}

	public void displaySmarhphone() {
		System.out.println("\t" + this.phoneName + ":");
		System.out.println("- it has a " + this.theCase.getCaseColor() + " " + this.theCase.getCaseType() + " case");
		System.out.println("- " + this.theScreen.getNoPixel() + " pixels");
		System.out.print("- width: " + this.theScreen.getDimensions().getWidth());
		System.out.print(", length: " + this.theScreen.getDimensions().getLength());
		System.out.print(", depth: " + this.theScreen.getDimensions().getDepth() + "\n");
		System.out.println("- current speaker volume: " + this.theSpeaker.getCrtVolume());
		System.out.println("- current microphone volume: " + this.theMicrophone.getCrtVolume());
	}

}
