public class Tree {
    private int age;
    private double height;
    private double growthRate;

    public Tree(double growthRate) {
        height = 0.12;
        age = 1;
        this.growthRate = growthRate;
    }

    public String toString() {
        return "Tree(age = " + age + ", height = " + height + ")";
    }

    public void growOneYear() {
        age++;
        if (height * (1 + growthRate / 100) <= 14) height = height * (1 + growthRate / 100);
        else height = 14;
    }
}