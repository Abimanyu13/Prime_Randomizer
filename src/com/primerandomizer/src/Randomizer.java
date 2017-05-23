package com.primerandomizer.src;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Abimanyu
 * 
 */
public class Randomizer {

	static BlockingQueue<Integer> integerQueue = new ArrayBlockingQueue<>(1024);

	public BlockingQueue<Integer> getIntegerQueue() {
		return integerQueue;
	}

	/**
	 * This method generates a positive random number and 
	 * puts the value in integer queue.
	 *
	 */
	public static void getRandomNumber() {
		Random randomNumberGenerator = new Random();
		try {
			//The maximum value is set to 1000 and can be removed 
			//or changed accordingly
			int randomNumber = randomNumberGenerator.nextInt(1000);
			if(randomNumber <0){
				randomNumber = randomNumber * -1;
			}
			integerQueue.put(randomNumber);
			Prime.getPrimes(integerQueue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method prints the result in the System.out.
	 * 
	 */
	public static void printResults() {
		BlockingQueue<Result> results = Prime.getResultQueue();
		while (results!=null && !results.isEmpty()) {
			try {
				Result outputResult;
				outputResult = results.take();
				String isPrime = "";
				if (!outputResult.isResult()) {
					isPrime = "not";
				}
					System.out.println("Number " + outputResult.number + "  is " + isPrime + " a prime number");	
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
