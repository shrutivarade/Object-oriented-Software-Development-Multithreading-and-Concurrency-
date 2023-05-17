package edu.umb.cs681.hw12;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable{
	private BankAccount account;
	private AtomicBoolean flagAtomic = new AtomicBoolean(false);

	public void setFlagAtomic() {
		flagAtomic.set(true);
	}

	public WithdrawRunnable(BankAccount account) {
		this.account = account;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++) {
			try {
				if (flagAtomic.get()) {
					System.out.println(Thread.currentThread().threadId()+" (w) : "+"Stop Accessing Bank Account by flag based termination");
					return;
				}
				account.withdraw(100);
				Thread.sleep(Duration.ofSeconds(2));
			} catch (InterruptedException exception) {
				System.out.println(exception.toString());
				continue;
			}
		}
	}
}
