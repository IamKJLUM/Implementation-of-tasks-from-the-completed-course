public class Manager implements Employee {

    private final int PERCENTAGE_BONUS = 5;
    private double salary = 91_128;

    public Manager() {
        calculateSalary();
    }

    private void calculateSalary() {

        salary = salary + (getContributionManager() / 100 * PERCENTAGE_BONUS);
    }

    private double getContributionManager() {

        double coff = 0.82145;

        while (true) {

            double contributionManager = Math.random();

            if (contributionManager >= coff) {
                coff = contributionManager * 140_000;
                break;
            }

            contributionManager = coff + contributionManager;

            if (contributionManager < 1 && contributionManager >= coff) {
                coff = contributionManager * 140_000;
                break;
            }

            contributionManager = (contributionManager / 2) + (coff / 2);

            if (contributionManager < 1 && contributionManager >= coff) {
                coff = contributionManager * 140_000;
                break;
            }
        }
        return coff;
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

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return Double.compare(getMonthSalary(), employee.getMonthSalary());
    }
}
