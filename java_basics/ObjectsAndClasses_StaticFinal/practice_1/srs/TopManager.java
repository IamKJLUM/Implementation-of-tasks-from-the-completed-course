public class TopManager implements Employee {

    private final double companyIncome;
    private final int PERCENTAGE_BONUS = 150;
    private final int INCOME_THRESHOLD = 10_000_000;
    private double salary = 97_754;

    public TopManager(Company companyIncome) {

        companyIncome.calculateIncomeCompany();
        this.companyIncome = companyIncome.getIncome();
        calculateSalary();
    }

    private void calculateSalary() {
        if (companyIncome > INCOME_THRESHOLD) {
            salary += salary / 100 * PERCENTAGE_BONUS;
        }
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return Double.compare(getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {

        String start = String.valueOf((int) getMonthSalary());
        String finish;

        finish = " " + start.substring(start.length() - 3);

        if (start.length() == 5) {

            start = "" + start.charAt(0) + start.charAt(1);

        } else {

            start = "" + start.charAt(0) + start.charAt(1) + start.charAt(2);
        }

        return start + finish + " руб.";
    }
}
