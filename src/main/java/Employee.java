import java.util.Scanner;

public class Employee {

    private String firstName;
    private String lastName;
    private String department;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
    }

    private String setDepartment() {
        Scanner reader = new Scanner(System.in);
        int choice;

        System.out.println("1. Development Department \n2. Sales Department \n3. HR Department");
        System.out.print("Type: ");
        choice = reader.nextInt();

        if (choice == 1) {
            return "dev";
        }
        else if (choice == 2) {
            return "sales";
        }
        else if (choice == 3) {
            return "hr";
        }

        return "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
