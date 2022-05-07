package edu.umb.cs681.hw13;

public class Main {
    public static void main(String[] args) throws Exception {

        ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
        WithdrawRunnable withdrawRunnable = new WithdrawRunnable(account);
        DepositRunnable depositRunnable = new DepositRunnable(account);


        Thread depositThread1 = new Thread(withdrawRunnable);
        Thread withdrawThread1 = new Thread(depositRunnable);
        Thread depositThread2 = new Thread(withdrawRunnable);
        Thread withdrawThread2 = new Thread(depositRunnable);
        Thread depositThread3 = new Thread(withdrawRunnable);
        Thread withdrawThread3 = new Thread(depositRunnable);
        Thread depositThread4 = new Thread(withdrawRunnable);
        Thread withdrawThread4 = new Thread(depositRunnable);
        Thread depositThread5 = new Thread(withdrawRunnable);
        Thread withdrawThread5 = new Thread(depositRunnable);
        Thread depositThread6 = new Thread(withdrawRunnable);
        Thread withdrawThread6 = new Thread(depositRunnable);
        Thread depositThread7 = new Thread(withdrawRunnable);
        Thread withdrawThread7 = new Thread(depositRunnable);
        Thread depositThread8 = new Thread(withdrawRunnable);
        Thread withdrawThread8 = new Thread(depositRunnable);
        Thread depositThread9 = new Thread(withdrawRunnable);
        Thread withdrawThread9 = new Thread(depositRunnable);
        Thread depositThread10 = new Thread(withdrawRunnable);
        Thread withdrawThread10 = new Thread(depositRunnable);

        depositThread1.start();
        withdrawThread1.start();
        depositThread2.start();
        withdrawThread2.start();
        depositThread3.start();
        withdrawThread3.start();
        depositThread4.start();
        withdrawThread4.start();
        depositThread5.start();
        withdrawThread5.start();
        depositThread6.start();
        withdrawThread6.start();
        depositThread7.start();
        withdrawThread7.start();
        depositThread8.start();
        withdrawThread8.start();
        depositThread9.start();
        withdrawThread9.start();
        depositThread10.start();
        withdrawThread10.start();

        withdrawRunnable.setDone();
        depositRunnable.setDone();

        depositThread1.interrupt();
        withdrawThread1.interrupt();
        depositThread2.interrupt();
        withdrawThread2.interrupt();
        depositThread3.interrupt();
        withdrawThread3.interrupt();
        depositThread4.interrupt();
        withdrawThread4.interrupt();
        depositThread5.interrupt();
        withdrawThread5.interrupt();
        depositThread6.interrupt();
        withdrawThread6.interrupt();
        depositThread7.interrupt();
        withdrawThread7.interrupt();
        depositThread8.interrupt();
        withdrawThread8.interrupt();
        depositThread9.interrupt();
        withdrawThread9.interrupt();
        depositThread10.interrupt();
        withdrawThread10.interrupt();


        try {
            depositThread1.join();
            depositThread2.join();
            depositThread2.join();
            depositThread4.join();
            depositThread5.join();
            depositThread6.join();
            depositThread7.join();
            depositThread8.join();
            depositThread9.join();
            depositThread10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
