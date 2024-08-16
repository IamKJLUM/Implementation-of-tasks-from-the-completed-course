public class Operator implements Employee {

    private final int solary = 39_860;

    @Override
    public double getMonthSalary() {
        return solary;
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
