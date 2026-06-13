import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private int nextId = 1;

    public void addStudent(String name, String email,
                           String phone, double marks) {
        Student s = new Student(nextId++, name,
                                email, phone, marks);
        students.add(s);
        System.out.println("\n✅ Student added successfully!");
        s.display();
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\n⚠️  No students found!");
            return;
        }
        System.out.println("\n========== ALL STUDENTS ==========");
        System.out.println("+------+----------------------+--------+-------+");
        System.out.println("| ID   | Name                 | Marks  | Grade |");
        System.out.println("+------+----------------------+--------+-------+");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("+------+----------------------+--------+-------+");
        System.out.println("Total Students: " + students.size());
    }

    public void searchByName(String name) {
        System.out.println("\n🔍 Search Results for: " + name);
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase()
                  .contains(name.toLowerCase())) {
                s.display();
                found = true;
            }
        }
        if (!found) System.out.println("❌ No student found!");
    }

    public void searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\n✅ Student Found:");
                s.display();
                return;
            }
        }
        System.out.println("❌ Student with ID "
                           + id + " not found!");
    }

    public void updateStudent(int id, String name,
                               String email, String phone,
                               double marks) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setEmail(email);
                s.setPhone(phone);
                s.setMarks(marks);
                System.out.println(
                    "\n✅ Student updated successfully!");
                s.display();
                return;
            }
        }
        System.out.println("❌ Student with ID "
                           + id + " not found!");
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(
            s -> s.getId() == id);
        if (removed) {
            System.out.println(
                "✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Student with ID "
                               + id + " not found!");
        }
    }

    public void showStatistics() {
        if (students.isEmpty()) {
            System.out.println("⚠️  No data available!");
            return;
        }
        double total = 0, highest = 0, lowest = 100;
        String topStudent = "", weakStudent = "";

        for (Student s : students) {
            total += s.getMarks();
            if (s.getMarks() > highest) {
                highest = s.getMarks();
                topStudent = s.getName();
            }
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
                weakStudent = s.getName();
            }
        }

        System.out.println("\n========== STATISTICS ==========");
        System.out.println("Total Students : " + students.size());
        System.out.printf("Average Marks  : %.2f%%%n",
                          total / students.size());
        System.out.println("Highest Marks  : " + highest
                           + "% (" + topStudent + ")");
        System.out.println("Lowest Marks   : " + lowest
                           + "% (" + weakStudent + ")");
        System.out.println("=================================");
    }

    public void sortByMarks() {
        Collections.sort(students,
            Comparator.comparingDouble(
                Student::getMarks).reversed());
        System.out.println("\n📊 Students sorted by marks:");
        viewAllStudents();
    }

    public void countByGrade() {
        int aPlus=0, a=0, b=0, c=0, d=0, f=0;
        for (Student s : students) {
            switch (s.getGrade()) {
                case "A+": aPlus++; break;
                case "A":  a++;     break;
                case "B":  b++;     break;
                case "C":  c++;     break;
                case "D":  d++;     break;
                case "F":  f++;     break;
            }
        }
        System.out.println("\n📊 Grade Distribution:");
        System.out.println("A+ (90-100%) : " + aPlus + " students");
        System.out.println("A  (80-89%)  : " + a     + " students");
        System.out.println("B  (70-79%)  : " + b     + " students");
        System.out.println("C  (60-69%)  : " + c     + " students");
        System.out.println("D  (50-59%)  : " + d     + " students");
        System.out.println("F  (below50%): " + f     + " students");
    }
}