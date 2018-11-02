package myJavaTraining.projects.smartphone;

public abstract class Phone {
	//fields
	protected String phoneName;
	protected Screen theScreen;
	protected Speaker theSpeaker;
	protected Microphone theMicrophone;

	//constructors
	public Phone(String phoneName, int noPixels, double screenWidth, double screenLength, double screenDepth, int speakerMaxVol, int micMaxVol) {
		this.phoneName = phoneName;
		this.theScreen = new Screen(noPixels, screenWidth, screenLength, screenDepth);
		this.theSpeaker = new Speaker(speakerMaxVol);
		this.theMicrophone = new Microphone(micMaxVol);
	}

	public Phone(String phoneName, int noPixels, double screenWidth, double screenLength, double screenDepth, 
			int speakerMaxVol, int micMaxVol, int speakerCrtVol, int micCrtVol) {
		this.phoneName = phoneName;
		this.theScreen = new Screen(noPixels, screenWidth, screenLength, screenDepth);
		this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
		this.theMicrophone = new Microphone(micMaxVol, micCrtVol);
	}

	//methods
	public abstract void pressVolumeUp();
	public abstract void pressVolumeDown();
	public abstract void increaseMicrophoneVolume();
	public abstract void decreaseMicrophoneVolume();
	public abstract void openPhone();
}
