package myJavaTraining.projects.smartphone;

public class App {
	
	/* 	  OUTPUT:
	 * 			iPhone 7:
	 *	- it has a leather dark red case
	 *	- 1000500 pixels
	 *	- width: 6.7, length: 13.8, depth: 0.7
	 *	- current speaker volume: 79
	 *	- current microphone volume: 20
     *
	 *	class Case: Power button pressed.
	 *	class Case: Volume UP pressed.
 	 *
	 *			iPhone 7:
	 *	- it has a leather dark red case
	 *	- 1000500 pixels
	 *	- width: 6.7, length: 13.8, depth: 0.7
	 *	- current speaker volume: 80
	 *	- current microphone volume: 15 
	 */

	public static void main(String[] args) {
		Smartphone iPhone7 = new Smartphone("iPhone 7", 1_000_500, 6.7, 13.8, 0.7, "leather", "dark red", 100, 100, 79, 20);
		
		iPhone7.displaySmarhphone(); //initial state
		System.out.println();
		
		iPhone7.openPhone(); //pressing the power on the case
		iPhone7.decreaseMicrophoneVolume();
		iPhone7.decreaseMicrophoneVolume();
		iPhone7.decreaseMicrophoneVolume();
		iPhone7.decreaseMicrophoneVolume();
		iPhone7.decreaseMicrophoneVolume();
		iPhone7.pressVolumeUp();
		System.out.println();
		
		iPhone7.displaySmarhphone(); //current state
		
		
	}

}
