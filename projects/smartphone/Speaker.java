package myJavaTraining.projects.smartphone;

public class Speaker {
	//fields
	private int maxVolume;
	private int crtVolume;

	//constructors
	public Speaker(int maxVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = 25 * maxVolume / 100;
	}

	public Speaker(int maxVolume, int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}

	//methods
	public boolean increaseVolume() {
		if (crtVolume < maxVolume) {
			crtVolume++;
			return true;
		}
		return false;
	}

	public boolean decreaseVolume() {
		if (crtVolume > 0) {
			crtVolume--;
			return true;
		}
		return false;
	}

	public void setSilenceMode() {
		this.crtVolume = 0;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public int getCrtVolume() {
		return crtVolume;
	}
	
}
