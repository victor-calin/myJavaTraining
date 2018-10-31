package myJavaTraining.concurency;

public class myThread extends Thread {
	private String name;
	private int[] values;
	private int start;
	private int end;

	public myThread(String name, int[] array, int start, int end) {
		this.name = name;
		this.values = array;
		this.start= start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=this.start; i<this.end; i++) {
			
			int aux = values[i];
			values[i] = reverse(values[i]);
			System.out.println("[" + this.name + "] [Position: " + i + " ] [Initial: " + aux + "]" +
							   " [Reversed: " + values[i] + " ]");
		}
	}
	
	private int reverse (int n) {
		int res = 0;
		while(n > 0) {
			res = res * 10 + n % 10;
			n /= 10;			
		}
		return res;
	}

}
