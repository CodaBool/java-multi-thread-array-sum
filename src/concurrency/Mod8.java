package concurrency;

import java.util.stream.*;

public class Mod8 {
	public static void main(String[] args) {
		Setup start = new Setup();
		int[] arr = new int[Setup.LENGTH];
		arr = start.generateArry();
		start.splitArray(arr); //Splits the array into two arrays a & b
		Thread t1 = new Thread (new Runnable() {
			public void run() {
				Setup.sumA = IntStream.of(Setup.a).sum();
			}
		});
		Thread t2 = new Thread (new Runnable() {
			public void run() {
				Setup.sumB = IntStream.of(Setup.b).sum();
			}
		});
		long startTime = System.nanoTime();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/ 1000000;  //1000000 to get milliseconds
		System.out.println("The sum is " + (Setup.sumA+Setup.sumB) + " | Using 2 Threads | Answer found in " + duration + "ms");
		startTime = System.nanoTime();
		int sum = IntStream.of(arr).sum();
		endTime = System.nanoTime();
		duration = (endTime - startTime)/ 1000000;  //1000000 to get milliseconds
		System.out.println("The sum is " + (sum) + " | Using 1 Threads | Answer found in " + duration + "ms");
		
	}

}
