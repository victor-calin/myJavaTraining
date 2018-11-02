package myJavaTraining.projects.smartphone;

import java.util.ArrayList;

public class Screen {
	//fields
	private ArrayList<Pixel> pixels; //composition
	private Dimensions dimensions; //composition

	//constructors
	public Screen(int noPixels, double width, double length, double depth) {
		this.pixels = new ArrayList<Pixel>(noPixels);
		for (int i=0; i<noPixels; i++) {
			this.pixels.add(new Pixel());
		}
		this.dimensions = new Dimensions(width, length, depth);
	}

	//methods
	public void setPixel(int pixelIndex, String color) {
		this.pixels.get(pixelIndex).setPixel(color); //delegate setPixel
	}

	public void colorScreen(String color) {
		for (int i=0; i<this.pixels.size(); i++) {
			this.setPixel(i, color);
		}
	}
	
	public int getNoPixel() {
		return this.pixels.size();
	}

	public ArrayList<Pixel> getPixels() {
		return pixels;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}
	
}
