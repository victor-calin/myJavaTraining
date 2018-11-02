package myJavaTraining.projects.fantasyWorld;

public class Parameters {
	private String OS;
	private String gamePath;
	private String credentials;
	private int noLives;

	public Parameters(String OS, String gamePATH, String credentials, int noLives) {
		this.OS = OS;
		this.gamePath = gamePATH;
		this.credentials = credentials;
		this.noLives = noLives;
	}
	
	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public String getGamePath() {
		return gamePath;
	}

	public void setGamePath(String gamePath) {
		this.gamePath = gamePath;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public int getNoLives() {
		return noLives;
	}

	public void setNoLives(int noLives) {
		this.noLives = noLives;
	}

	@Override
	public String toString() {
		return "OS: " + this.OS + "\nGame Path: " + this.gamePath + 
			   "\nCredentials: " + this.credentials + "\nNo. lives remaining: " + this.noLives;
	}
	
}