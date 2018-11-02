package myJavaTraining.projects.surpriseGenerator;

public class BagFactory implements IBagFactory {

	public IBag makeBag(String type) {
		switch(type.toLowerCase()) {
		case "fifo":
			return new Fifo();
		case "lifo":
			return new Lifo();
		default:
			return new Arbitrary();
		}
	}

}
