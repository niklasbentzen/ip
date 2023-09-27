import java.util.TreeMap;
import java.util.Scanner;

public class ShoppingList {

    TreeMap<String, Integer> shoppingList;
    TreeMap<String, Integer> available;

    public ShoppingList() {
        shoppingList = new TreeMap<>();
        available = new TreeMap<>();
    }

    public void read() {
        Scanner s = new Scanner(System.in);
        String ingredient;

        String mapPointer = "";

        String name;
        int amount;
        String unit;

        while (s.hasNextLine() && !(ingredient = s.nextLine()).isEmpty()) {
            String[] ingredientSplit = ingredient.split(" ");

            switch (ingredientSplit[0]) {
                case ("AVAILABLE"), ("RECIPE") :
                    mapPointer = ingredientSplit[0];
                    break;
                default :
                    amount = Integer.parseInt(ingredientSplit[0]);
                    unit = ingredientSplit[1];
                    name = ingredientSplit[2];

                    if (unit.equals("kg")) { //checks if the unit is correct, if not, corrects it
                        amount = amount * 1000;
                    }

                    if (mapPointer.equals("AVAILABLE")) available.put(name, amount);
                    else {
                        if (available.containsKey(name)) { //if ingredient is available
                            int availableAmount = available.get(name) - amount;
                            if (availableAmount >= 0) {
                                available.replace(name, availableAmount);
                            } else {
                                shoppingList.put(name, availableAmount * -1);
                                available.remove(name);
                            }
                        } else if (shoppingList.containsKey(name)) { //if ingredient is in the shoppingList already
                            amount = shoppingList.get(name) + amount;
                            shoppingList.replace(name, amount);
                        } else { //if ingredient is neither available and in shoppingList
                            shoppingList.put(name, amount);
                        }
                    }
            }
        }
    }

    public void printShoppingList() {
        System.out.println("Shopping List:");
        for (String item:
             shoppingList.keySet()) {
            int amount = shoppingList.get(item);
            System.out.println(amount + " g " + item);
        }
    }
}