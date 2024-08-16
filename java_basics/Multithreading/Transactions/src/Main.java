import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    private static long totalAmount;

    public static List<Account> createSomeAccounts(int countAcc) {
        List<Account> accounts = new ArrayList<>();

        IntStream.range(1, countAcc + 1).forEach(i -> {

            long clientMoney = new Random().nextInt(100_000);
            totalAmount += clientMoney;
            accounts.add(
                    new Account(
                            clientMoney,
                            String.valueOf(i)));
        });

        return accounts;
    }

    public static void someOperations(List<Account> someAcc, TransactionRunner transactionRunner, int threadCount) {

        List<Thread> threads = new ArrayList<>();

        Bank bank = Bank.getInstance();
        bank.setAccounts(someAcc);

        for (int i = 0; i < Math.min(threadCount, Runtime.getRuntime().availableProcessors()); i++) {

            threads.add(new Thread(transactionRunner));
            threadCount += 1;
        }

        threads.forEach(Thread::start);
        threads.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException ignored) {}
        });
    }

    public static long getTotalAmount() {
        return totalAmount;
    }
}
