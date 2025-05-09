import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrganisationPrototype {
    private List<Employee> employees;

    public OrganisationPrototype() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter manager type: ");
        String managerType = scanner.nextLine();

        Employee employee = new Employee(name, department, managerType);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void searchEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                System.out.println("Employee found!");
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Manager Type: " + employee.getManagerType());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void sortEmployees() {
        Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("Employees sorted successfully!");
    }

    public void generateRandomEmployees() {
        String[] names = {"John", "Jane", "Bob", "Alice", "Mike"};
        String[] departments = {"Sales", "Marketing", "IT", "HR", "Finance"};
        String[] managerTypes = {"Manager", "Team Lead", "Director"};

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = names[random.nextInt(names.length)];
            String department = departments[random.nextInt(departments.length)];
            String managerType = managerTypes[random.nextInt(managerTypes.length)];

            Employee employee = new Employee(name, department, managerType);
            employees.add(employee);
        }
        System.out.println("Random employees generated successfully!");
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Manager Type: " + employee.getManagerType());
            System.out.println();
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Sort Employees");
            System.out.println("4. Generate Random Employees");
            System.out.println("5. Display Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    sortEmployees();
                    break;
                case 4:
                    generateRandomEmployees();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        OrganisationPrototype organisation = new OrganisationPrototype();
        organisation.displayMenu();
    }
}
