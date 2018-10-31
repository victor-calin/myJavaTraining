package myJavaTraining.basicAlgorithms;

public class SearchingAlgorithms {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

		System.out.println(recursiveBinarySearch(a, 0, 19, 16));

	}

	//linear search---------------------------------
	public static int linearSearch(int[] a, int x) {
		for(int i=0; i<a.length; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}


	//recursive linear search----------------------------
	public static int recursiveLinearSearch(int[] a, int i, int x) {
		if(i > a.length-1) {
			return -1;
		} else if (a[i] == x) {
			System.out.print("found at: ");
			return i;
		} else {
			System.out.println("not at index : " + i);
			return recursiveLinearSearch(a, i+1, x);
		}
	}


	//binary search--------------------------------------
	public static int binarySearch(int[] a, int x) {
		int b = 0;
		int e = a.length-1;
		int h = 0;
		while(b <= e) {
			h = (b + e) / 2;
			if (x < a[h]) e = h-1;
			else if (x > a[h]) b = h+1;
			else return h;
		}
		return -1;
	}


	//recursive binary search-----------------------------
	public static int recursiveBinarySearch(int[] a, int b, int e, int x) {
		System.out.println("[ " + b + "..." + e + " ]");
		if (b > e) {
			return -1;
		} else {
			int h = (b+e) / 2;
			if (a[h] == x) {
				return h;
			} else if (a[h] > x) {
				return recursiveBinarySearch(a, b, h-1, x);
			} else {
				return recursiveBinarySearch(a, h+1, e, x);
			}
		}
	}

}