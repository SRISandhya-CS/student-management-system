import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        // Sample data already loaded
        manager.addStudent("Sridhar",
            "Sridhar@gmail.com", "1234567890", 92.5);
        manager.addStudent("Sandhya",
            "Sandhya@gmail.com",   "0987654321", 88.0);
        manager.addStudent("Sowmya",
            "Sowmya@gmail.com", "1122334455", 85.5);
        manager.addStudent("Viswa Sree",
            "viswa@gmail.com", "5544332211", 65.0);
        manager.addStudent("Kavya",
            "kavya@gmail.com",   "9988776655", 45.0);

        System.out.println(
            "╔══════════════════════════════╗");
        System.out.println(
            "║  STUDENT MANAGEMENT SYSTEM   ║");
        System.out.println(
            "║     Built with Java & OOP    ║");
        System.out.println(
            "╚══════════════════════════════╝");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addStudentFlow();          break;
                case 2: manager.viewAllStudents(); break;
                case 3: searchFlow();              break;
                case 4: updateFlow();              break;
                case 5: deleteFlow();              break;
                case 6: manager.showStatistics();  break;
                case 7: manager.sortByMarks();     break;
                case 8: manager.countByGrade();    break;
                case 9:
                    System.out.println(
                        "\n👋 Thank you! Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println(
                        "❌ Invalid choice! Try again.");
            }
        }
        sc.close();
    }

    static void showMenu() {
        System.out.println(
            "\n╔══════════════════════════╗");
        System.out.println(
            "║         MAIN MENU        ║");
        System.out.println(
            "╠══════════════════════════╣");
        System.out.println(
            "║  1. Add Student          ║");
        System.out.println(
            "║  2. View All Students    ║");
        System.out.println(
            "║  3. Search Student       ║");
        System.out.println(
            "║  4. Update Student       ║");
        System.out.println(
            "║  5. Delete Student       ║");
        System.out.println(
            "║  6. Statistics           ║");
        System.out.println(
            "║  7. Sort by Marks        ║");
        System.out.println(
            "║  8. Grade Distribution   ║");
        System.out.println(
            "║  9. Exit                 ║");
        System.out.println(
            "╚══════════════════════════╝");
    }

    static void addStudentFlow() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        System.out.print("Name   : ");
        String name = sc.nextLine();
        System.out.print("Email  : ");
        String email = sc.nextLine();
        System.out.print("Phone  : ");
        String phone = sc.nextLine();
        double marks = getDoubleInput("Marks  : ");
        manager.addStudent(name, email, phone, marks);
    }

    static void searchFlow() {
        System.out.println("\n--- SEARCH STUDENT ---");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by ID");
        int choice = getIntInput("Choice: ");
        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            manager.searchByName(name);
        } else {
            int id = getIntInput("Enter ID: ");
            manager.searchById(id);
        }
    }

    static void updateFlow() {
        System.out.println("\n--- UPDATE STUDENT ---");
        manager.viewAllStudents();
        int id = getIntInput(
            "Enter student ID to update: ");
        System.out.print("New Name   : ");
        String name = sc.nextLine();
        System.out.print("New Email  : ");
        String email = sc.nextLine();
        System.out.print("New Phone  : ");
        String phone = sc.nextLine();
        double marks = getDoubleInput("New Marks  : ");
        manager.updateStudent(
            id, name, email, phone, marks);
    }

    static void deleteFlow() {
        System.out.println("\n--- DELETE STUDENT ---");
        manager.viewAllStudents();
        int id = getIntInput(
            "Enter student ID to delete: ");
        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            manager.deleteStudent(id);
        } else {
            System.out.println("❌ Delete cancelled.");
        }
    }

    static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print(
                "Invalid! Enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print(
                "Invalid! Enter a number: ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}