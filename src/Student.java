public class Student {
    private String studentName;
    private int rollNo;


    public Student(String studentName, int rollNo) {
        this.studentName = studentName;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student Name -> "+studentName+" | "+"Roll no: -> "+rollNo;
    }

    public boolean matchesName(String name) {
        return studentName.equalsIgnoreCase(name);
    }
}
