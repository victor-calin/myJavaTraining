package myJavaTraining.concurency;
import java.util.ArrayList;
import java.util.Random;

public class App {
	
	/* Given an int array of random numbers, use 3 threads
	 * to reverse each number in the array along with a message containing:
	 * [thread number] [array index] [initial number] [reversed number]
	 * 
	 * example: [1] [Position:  2 ] [Initial:  398] [Reversed:  893 ]
		        [3] [Position: 26 ] [Initial: 4931] [Reversed: 1394 ]
                [2] [Position: 13 ] [Initial: 7793] [Reversed: 3977 ]
	 */
	
	static int[] array;
	static ArrayList<myThread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		Random random = new Random();
		array =  new int[30];
		
		for(int i=0; i<array.length; i++) {
			array[i] = random.nextInt(10000);
		}
		
		int splitPoint = array.length / 3;
		
		for(int i=0; i<3; i++) {
			myThread th = new myThread(""+(i+1), array, splitPoint*i, splitPoint*(i+1));
			threadList.add(th);
		}
		
		for(int i=0; i<threadList.size(); i++) {
			threadList.get(i).start();
		}
	}

}
