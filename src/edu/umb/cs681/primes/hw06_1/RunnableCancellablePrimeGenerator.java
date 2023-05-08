package edu.umb.cs681.primes.hw06_1;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock(); // Added the reentrantLock as a data field to gaurd the shared variable 'done'
	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void setDone(){ //revise setDone()
		lock.lock();
		try{
			done = true;
		}
		finally{
			lock.unlock();
		}

	}

	public void generatePrimes(){ //revised generatePrime() to access 'done' with the lock
		for (long n = from; n <= to; n++) {

			lock.lock();
			try{
				// Stop generating prime numbers if done==true
				if(done){
					System.out.println("Stopped generating prime numbers.");
					this.primes.clear();
					break;
				}
				if( isPrime(n) ){ this.primes.add(n); }
			}
			finally {
				lock.unlock();
			}

		}
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1,100);
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimes().size() + " prime numbers are found.");
 	}
}
