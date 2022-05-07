package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable {
    public AtomicBoolean done = new AtomicBoolean(false);
    private final BankAccount account;

    public WithdrawRunnable(BankAccount account) {
        this.account = account;
    }

    public void setDone() {
        done.set(true);
    }

    public void run() {
        while (true) {
            if (done.get()) {
                System.out.println(Thread.currentThread().getName() + " Money deposited!");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " Money depositing...");
            account.withdraw(300);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {

            }
        }
    }
}
