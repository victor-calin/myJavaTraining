package myJavaTraining.projects.smartphone;

public class Pixel {
	//fields
	private String color;

	//constructors
	public Pixel() {
		this.color = "#FFFFFF";
	}

	public Pixel(String color) {
		this.color = color;
	}

	//methods
	public void setPixel(String color) {
		this.color = color;
	}
}
