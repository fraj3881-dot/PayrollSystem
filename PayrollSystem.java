import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee("E001", "Ahmed", 5000, LocalDate.of(2020, 3, 15), 800));
        employees.add(new FullTimeEmployee("E002", "Sara", 7000, LocalDate.of(2018, 7, 1), 1200));
        employees.add(new FullTimeEmployee("E003", "Khaled", 4000, LocalDate.of(2022, 1, 10), 500));
        employees.add(new ContractorEmployee("C001", "Omar", LocalDate.of(2021, 5, 20), 50, 160));
        employees.add(new ContractorEmployee("C002", "Layla", LocalDate.of(2023, 9, 1), 30, 120));

        System.out.println("===== Sorted by Net Salary (High to Low) =====");
        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("===== Sorted by Join Date (Oldest First) =====");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee first, Employee second) {
                return first.getJoinDate().compareTo(second.getJoinDate());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        double performanceScore = 4.5;
        double totalTax = 0;
        double totalBonus = 0;

        for (Employee employee : employees) {
            totalTax += employee.calculateTax();
            totalBonus += employee.calculateBonus(performanceScore);
        }

        System.out.println();
        System.out.println("===== Totals =====");
        System.out.printf("Performance Score: %.1f%n", performanceScore);
        System.out.printf("Total Tax: %.2f%n", totalTax);
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }
}
