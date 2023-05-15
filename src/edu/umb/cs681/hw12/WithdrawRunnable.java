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

		try{
			for(int i = 0; i < 10; i++){
				if(flagAtomic.get()){
					break;
				}
				account.withdraw(100);
				Thread.sleep( Duration.ofSeconds(2) );
			}
		}catch(InterruptedException exception){}

	}
}
