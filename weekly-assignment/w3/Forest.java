import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees;

    public Forest() {
        trees = new ArrayList<>();
    }

    public void addTree(int growthRate) {
        trees.add(new Tree(growthRate));
    }

    public String toString() {

        String s = "Forest(";
        for (Tree t :
                trees) {
            s += t;
        }
        s += ")";
        return s;
    }

    public void growOneYear() {
        for (Tree t :
                trees) {
            t.growOneYear();
        }

    }
}
