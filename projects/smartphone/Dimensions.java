package myJavaTraining.projects.smartphone;

public class Dimensions {
	//fields
	private final double width;
	private final double length;
	private final double depth;

	//constructors
	public Dimensions(double width, double length, double depth) {
		this.width = width;
		this.length = length;
		this.depth = depth;
	}
	
	//methods
	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getDepth() {
		return depth;
	}
		
}
