import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {
    protected List<String> toppings;

    public Pizza() {
        super("Pizza", 45);
        toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
        price += 10;
    }

    public void setName(String name) {
        super.name = name;
    }

    @Override
    public void display() {
        super.display();
        System.out.print(" {");
        String separator = " ";  // first, no space
        for (String topping:
             toppings) {
            System.out.print(separator);
            System.out.print(topping);
            separator = ", ";  // after first iteration, a space between the words
        }
        System.out.print(" }");
    }
}
