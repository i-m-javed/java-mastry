package training;

import java.util.concurrent.atomic.AtomicLong;

public class payment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wallet w = new wallet();
		w.setStartingBalance(5000);
		System.out.println(w.getBalance());
		w.debit(1000);
		System.out.println(w.getBalance());
		w.credit(200);
		System.out.println(w.getBalance());

	}

}

class wallet {
	AtomicLong balance = new AtomicLong(0);

	public void setStartingBalance(long amount) {
		if (amount < 0) {
			System.out.println("Starting balancce can't be negative");
			return;
		} else {
			balance.set(amount);
		}
	}

	public void debit(long amount) {
		if (amount < 0) {
			System.out.println("Negative amount can not be debited");
			return;
		}
		while (true) {
			
			long crrBalance = balance.get();
			if (crrBalance < amount) {
				System.out.println("Available balance is less then amount to be debited");
				return;
			}
			long update = crrBalance - amount;
			if (balance.compareAndSet(crrBalance, update)) {
				System.out.println("Transcation successful");
				return;
			}
		}
	}

	public void credit(long amount) {
		if (amount < 0) {
			System.out.println("Negative amount can not be credited");
			return;
		}
		while (true) {
			
			long crrBalance = balance.get();
			long update = crrBalance + amount;
			if (balance.compareAndSet(crrBalance, update)) {
				System.out.println("Transcation successful");
			}
		}
	}

	public long getBalance() {
		return balance.get();
	}
}
