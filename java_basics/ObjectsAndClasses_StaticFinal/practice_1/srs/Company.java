import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private double companyIncome;
    public ArrayList<Employee> employeesList = new ArrayList<>();

    public Company() {
        calculateIncomeCompany();
    }


    public List<Employee> getTopSolaryStaff(int count) {

        if (count > 0) {
            ArrayList<Employee> topSolaryList = new ArrayList<>();

            for (int i = count - 1; i >= 0; i--) {

                topSolaryList.add(employeesList.get(i));

            }
            return topSolaryList;
        }
        return new ArrayList<>();
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        if (count > 0) {

            return new ArrayList<>(employeesList);
        }
        return new ArrayList<>();
    }

    public void calculateIncomeCompany() {
        companyIncome = Math.random() * 50_000_000;

    }

    public void hire(Employee employee) {
        employeesList.add(employee);
    }

    public void fire(Employee employee) {

        for (int i = 0; i < employeesList.size(); i++) {

            if (employeesList.get(i).equals(employee)) {
                employeesList.remove(i);
            }
        }
    }

    public void hireAll(ArrayList<Employee> employeesList) {

        Collections.sort(employeesList);
        this.employeesList.addAll(employeesList);

    }

    public double getIncome() {
        return companyIncome;
    }
}
