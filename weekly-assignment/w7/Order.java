import java.util.ArrayList;
import java.util.List;

public class Order {
    protected List<Food> ordered;

    public Order() {
        ordered = new ArrayList<>();
    }

    public void addFood(Food food) {
        ordered.add(food);
    }

    public int total() {
        int totalPrice = 0; 
        for (Food item:
             ordered) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void display() {
        for (Food item:
             ordered) {
            item.display();
            System.out.println();
        }
        System.out.print(total() + " kr TOTAL");
    }

    public boolean payWith (CreditCard card) {
        boolean paymentResult = card.withdraw(total());
        if (!paymentResult) System.out.println("ERROR: Payment failed");
        return paymentResult;
    }
}