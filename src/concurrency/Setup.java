package concurrency;

import java.util.Random;

public class Setup {
	final static int LENGTH = 200000000;
	static int sum, sumA, sumB = 0;
	static int[] a = new int[(LENGTH + 1)/2];
	static int[] b = new int[LENGTH - a.length];
	
	public void splitArray(int arr[]) {
		for (int i = 0; i < LENGTH; i++) {
			if (i < a.length)
				a[i] = arr[i];
			else
				b[i - a.length] = arr[i];
		}
	}
	public int[] generateArry() {
		Random rand = new Random();
		int randomNum;
		int[] arr = new int[LENGTH];
		for (int i=0; i<LENGTH; i++) { //Creates an array of random numbers
			randomNum = rand.nextInt(10) + 1;
			arr[i] = randomNum;	
		}
		return arr;
	}

}
