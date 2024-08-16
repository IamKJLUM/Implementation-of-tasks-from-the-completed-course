import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing the operation of transactions in a multithreading")
public class TestTransactions {

    private Bank bank;
    private List<Account> accounts;
    private TransactionRunner transactionRunner;
    private int threadCount;


    @BeforeEach
    void in() {

        int percentFraud                 = 5;
        int countTransactionToOneProcess = 10;
        int countAccount                 = 100;

        bank = Bank.getInstance();
        threadCount = Runtime.getRuntime().availableProcessors();
        transactionRunner = new TransactionRunner(
                bank,
                countTransactionToOneProcess,
                percentFraud);
        accounts = Main.createSomeAccounts(countAccount);

    }

    @Test
    @DisplayName("Проверка итоговой суммы (100 клиентов, 16 процессов, 160 транзакций, 5% вероятность фрода)")
    public void checkTotalAmount() {


        Main.someOperations(accounts, transactionRunner, threadCount);
        long totalAmount = Main.getTotalAmount();

        assertEquals(totalAmount,
                bank.getSumAllAccounts());
    }

}