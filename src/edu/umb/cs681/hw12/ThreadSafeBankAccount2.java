package edu.umb.cs681.hw12;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 implements BankAccount {
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();
	
	public void deposit(double amount){
		lock.lock();
		try{
			System.out.println("DEPOSIT Lock obtained");
			System.out.println(Thread.currentThread().threadId() + 
					" (d): current balance: " + balance);
			while(balance >= 300){
				System.out.println(Thread.currentThread().threadId() + 
						" (d): await(): Balance exceeds the upper limit.");
				belowUpperLimitFundsCondition.await();
			}

			balance += amount;
			System.out.println(Thread.currentThread().threadId() + 
					" (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
		}
		catch (InterruptedException exception){
//			exception.printStackTrace();
			System.out.println(exception.toString());
		}


		finally{
			lock.unlock();
			System.out.println("DEPOSIT Lock released");
		}
	}
	
	public void withdraw(double amount){
		lock.lock();
		try{
			System.out.println("WITHDRAW Lock obtained");
			System.out.println(Thread.currentThread().threadId() + 
					" (w): current balance: " + balance);
			while(balance <= 0){
				System.out.println(Thread.currentThread().threadId() + 
						" (w): await(): Insufficient funds");
				sufficientFundsCondition.await();
			}

			balance -= amount;
			System.out.println(Thread.currentThread().threadId() + 
					" (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();
		}
		catch (InterruptedException exception){
			exception.printStackTrace();
		}
		finally{
			lock.unlock();
			System.out.println("WITHDRAW Lock released");
		}
	}

	public double getBalance() { return this.balance; }

	public static void main(String[] args){
		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		for(int i = 0; i < 5; i++){

			DepositRunnable dep = new DepositRunnable(bankAccount);
			Thread t1 = new Thread( dep );
			t1.start();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
			}
			dep.setFlagAtomic();
			t1.interrupt();


			WithdrawRunnable with = new WithdrawRunnable(bankAccount);
			Thread t2 = new Thread( with );
			t2.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			with.setFlagAtomic();
			t2.interrupt();


		}


	}
}
