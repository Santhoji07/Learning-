import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNo;
    private int[] marks;
    private int total;
    private float percentage;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public void calculate() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        percentage = total / (float) marks.length;
    }

    // Getters for displaying data
    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public int[] getMarks() { return marks; }
    public int getTotal() { return total; }
    public float getPercentage() { return percentage; }
}
