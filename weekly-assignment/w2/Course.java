public class Course {
    private String name;
    private int enrolments;

    public Course(String name, int enrolments) {
        this.name = name;
        this.enrolments = enrolments;
    }

    public String getName() {
        return name;
    }

    public int getEnrolments() {
        return enrolments;
    }

    public String toString() {
        return "The name of the course is " + name + " and there are " + enrolments + " students enrolled in the course";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrolments(int enrolments) {
        if (enrolments < 0) System.out.println("The number of enrolled students cannot be negative!");
        else if (enrolments > 300) System.out.println("The number of enrolled students cannot be greater than 300!");
        else this.enrolments = enrolments;
    }
}
