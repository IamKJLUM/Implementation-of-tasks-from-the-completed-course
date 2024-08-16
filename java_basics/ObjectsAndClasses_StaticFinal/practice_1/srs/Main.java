import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        int countOperators = 180;
        int countManagers = 80;
        int countTopManager = 10;

        int getAll = countManagers + countTopManager + countOperators;

        ArrayList<Employee> employeeListCompany = new ArrayList<>(getAll);

        int max = Integer.max(countTopManager, Integer.max(countOperators, countManagers));

        for (int i = 0; i < max; i++) {

            if (i < countOperators) {

                employeeListCompany.add(new Operator());
            }
            if (i < countManagers) {

                employeeListCompany.add(new Manager());
            }
            if (i < countTopManager) {

                employeeListCompany.add(new TopManager(company));
            }
        }

        company.hireAll(employeeListCompany);

        System.out.println("Company\nТоп сотрудники:");
        System.out.println(company.getTopSolaryStaff(getAll));

        System.out.println("Альтернативный топ:");
        System.out.println(company.getLowestSalaryStaff(getAll));

        employeeListCompany.addAll(employeeListCompany);

        company.fire(employeeListCompany.get(1));

        System.out.println("\nОдного уволили, остаток сотрудников:");

        System.out.println(company.getTopSolaryStaff(getAll - 1));

        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());

        System.out.println("\nНаняли троих менеджеров, остаток сотрудников:");

        System.out.println(company.getTopSolaryStaff(getAll + 2));


        Company company1 = new Company();
        ArrayList<Employee> employeeListCompany1 = new ArrayList<>(getAll);
        company1.hire(new Manager());
        company1.hire(new Manager());

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\nCompany 1\nНаняли двоих менеджеров, остаток сотрудников:");
        System.out.println(company1.getTopSolaryStaff(2));


        for (int i = 0; i < max; i++) {

            if (i < countOperators) {

                employeeListCompany1.add(new Operator());
            }
            if (i < countManagers) {

                employeeListCompany1.add(new Manager());
            }
            if (i < countTopManager) {

                employeeListCompany1.add(new TopManager(company1));
            }
        }

        company1.hireAll(employeeListCompany1);
        System.out.println("\nНаняли еще некоторое кол-во сотрудников, остаток:");

        System.out.println(company1.getTopSolaryStaff(getAll + 2));

        for (int i = 0; i < (getAll + 2) / 2; i++) {
            company1.fire(company1.employeesList.get(i));
        }

        System.out.println(company1.getTopSolaryStaff(136));
    }
}
