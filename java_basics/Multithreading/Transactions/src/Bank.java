import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();
    private static Bank instance;

    private Bank() {}

    public static Bank getInstance () {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);

        synchronized (from.hashCode() > to.hashCode()? from: to) {
            synchronized (from.hashCode() > to.hashCode()? to: from) {

                if (amount > 50_000) {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        System.out.println("We have temporarily stopped operations on your account, please contact your bank to unblock it:" +
                                " Sender - [" + fromAccountNum + "], Recipient - [" + toAccountNum + "]");

                        from.setBlocker(true);
                        to.setBlocker(true);
                        return;
                    }
                }

                if ((to.getBlocker() || from.getBlocker()) && from.setMoney(from.getMoney() - amount)) {
                    if (to.setMoney(to.getMoney() + amount)) {
                        System.out.println("Transfer successful done");
                    }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return accounts.keySet().stream().mapToLong(k -> accounts.get(k).getMoney()).sum();
    }

    public void setAccounts(List<Account> accountsList) {
        accounts = new ConcurrentHashMap<>();
        accountsList.forEach(account ->
                accounts.put(account.getAccNumber(), account));
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
