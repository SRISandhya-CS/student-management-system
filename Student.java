public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private double marks;
    private String grade;

    public Student(int id, String name, String email,
                   String phone, double marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public double getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    public void display() {
        System.out.println("+----------------------------------+");
        System.out.println("  ID      : " + id);
        System.out.println("  Name    : " + name);
        System.out.println("  Email   : " + email);
        System.out.println("  Phone   : " + phone);
        System.out.println("  Marks   : " + marks + "%");
        System.out.println("  Grade   : " + grade);
        System.out.println("+----------------------------------+");
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-6.1f | %-5s |",
                id, name, marks, grade);
    }
}