package com.primerandomizer.src;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class is used to get the Integer Numbers from the integerQueue 
 * from Randomizer application and check whether the number is prime or not.
 * 
 * The result is sent in a BlockingQueue of Result, which would be accessed by 
 * PrintResult method of Randomizer application and printed in System.out.
 * 
 * @author Abimanyu
 *
 */
public class Prime {
	
	private static BlockingQueue<Result> resultQueue = new ArrayBlockingQueue<>(1024);;
	
	/**
	 * 
	 * @return resultQueue 
	 */
	public static BlockingQueue<Result> getResultQueue() {
		return resultQueue;
	}

	/**
	 * This method gets the integer from Integer queue and checks 
	 * whether the number is Prime or not and puts the value and result 
	 * in the ResultQueue.
	 * 
	 * @param integerQueue
	 * @return
	 */
	public static List<Result> getPrimes(BlockingQueue<Integer> integerQueue) {
		
		try {
			Integer number  = integerQueue.take();
			boolean isPrime = checkPrime(number);
			Result result = new Result();
			result.setNumber(number);
			result.setResult(isPrime);
			resultQueue.put(result);
			Randomizer.printResults();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
		    
	}

	/**
	 * This method checks whether the number is prime or not
	 * 
	 * @param number
	 * @return
	 */
	private static boolean checkPrime(Integer number) {
		boolean flag = true;
		int m=number/2;    
		for(int i=2;i<=m;i++){    
			if(number %i==0){    
				flag=false;    
				break;    
			}    
		 }
		return flag;
	}

}
