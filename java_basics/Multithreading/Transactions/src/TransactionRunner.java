import java.util.Random;

public class TransactionRunner implements Runnable {

    private final Bank bank;
    private final int countTransaction;
    private final int percentFraud;

    public TransactionRunner(Bank bank, int countTransaction, int percentFraud) {
        this.bank = bank;
        this.countTransaction = countTransaction;
        this.percentFraud = Math.min(percentFraud, 100);
    }

    @Override
    public void run() {
        runTransaction();
    }

    private void runTransaction() {

        Random randomToThreads = new Random();

        for (int i = 0; i < countTransaction; i++) {

            Account from = bank.getAccounts().get(
                    String.valueOf(randomToThreads.nextInt(bank.getAccounts().size()))
            );

            Account to = bank.getAccounts().get(
                    String.valueOf(randomToThreads.nextInt(bank.getAccounts().size()))
            );

            if (from == null || to == null) return;

            try {
                bank.transfer(
                        from.getAccNumber(),
                        to.getAccNumber(),
                        randomToThreads.nextInt(100) < (percentFraud * 2) ? 100_000 : randomToThreads.nextInt(49_999)
                );
            } catch (InterruptedException ignored) {}
        }
    }
}
