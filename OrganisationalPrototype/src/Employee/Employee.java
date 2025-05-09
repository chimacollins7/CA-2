package Employee;

public class Employee {
    private String name;
    private String department;
    private String managerType;

    public Employee(String name, String department, String managerType) {
        this.name = name;
        this.department = department;
        this.managerType = managerType;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}