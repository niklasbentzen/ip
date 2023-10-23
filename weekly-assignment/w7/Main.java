public class Main {
    public static void main(String[] args) {

        //Creating Food
        Food burger = new Food("Burger", 65);
        Food coke = new Food("Code", 25);

        //Make a Pizza
        Pizza pizza = new Pizza();
        pizza.addTopping("Pepperoni");
        pizza.addTopping("Pineapple");
        pizza.addTopping("Onion");

        Pizza pizza1 = new Pizza();

        //Make an order and add items
        Order o = new Order();
        o.ordered.add(burger);
        o.ordered.add(coke);
        o.ordered.add(pizza);
        o.ordered.add(pizza1);
        o.display();
    }
}
