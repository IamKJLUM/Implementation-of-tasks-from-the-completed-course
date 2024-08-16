import java.util.Objects;

public class Account {

    private long money;
    private final String accNumber;
    private boolean blocker = false;

    public Account(long money, String accNum) {
        if (money >= 0) this.money = money;
        this.accNumber = accNum;
    }

    public boolean setMoney(long money) {

            if (money >= 0) {
                this.money = money;
                return true;
            }
            System.out.println("The requested amount exceeds the balance:" +
                    "\n your account         [" + this.money + "]," +
                    "\n the requested amount [" + (this.money + (-money)) + "]");
        return false;
    }
    public long getMoney() {
            return money;
    }

    public String getAccNumber() {
            return accNumber;
    }

    public void setBlocker(boolean blocker) {
            this.blocker = blocker;
    }

    public boolean getBlocker() {
            return !blocker;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", locketAcc=" + blocker +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return money == account.money && Objects.equals(accNumber, account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, accNumber);
    }
}
