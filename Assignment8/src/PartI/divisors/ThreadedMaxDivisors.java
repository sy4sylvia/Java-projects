package PartI.divisors;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		//testing:
//		System.out.println("Thread " + this + " testing range " + min + " to " + max);
		Entry<Long, Long> et = CountDivisors.maxDivisors(min, max);
		long resultVal = et.getKey();
		long resultNum = et.getValue();
	}
	
	public static void main(String[] args) {

		long min = 100_000;
		long max = 200_000;

		int numOfThreads = 10;
		long numPerThreads = (max - min) / numOfThreads;
		long start = 1;  // Starting point of the range for first thread.
		long end = start + numPerThreads - 1;   // End point of the range.

		Set<Thread> threadSet = new HashSet<Thread>();
		threadSet.add(new Thread());
		for (Thread t: threadSet) t.start();

		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();

		for (int i = 0; i < numOfThreads; i++) {
			if (i == numOfThreads - 1) end = (max - min);
			divisorsSet.add(new ThreadedMaxDivisors(start, end));
			start = end + 1;
			end = start + numPerThreads - 1;
		}

		long startTime = System.currentTimeMillis();

		
		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then we can get the results of the threads once
		 * all of them are done
		 */
		for (Thread t: threadSet) {
			try {
				t.join();
				System.out.print("Done");
			} catch (InterruptedException e) {
//				e.printStackTrace();
				Thread.currentThread().interrupt();  // set interrupt flag
				System.out.println("Failed to return the largest number with the largest number of divisors.");
			}
		}
		
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			tmd.run();
		}

		System.out.println();

		long endTime = System.currentTimeMillis();

		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();

		System.out.println("\n" + number + " = " + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));

	}
}
