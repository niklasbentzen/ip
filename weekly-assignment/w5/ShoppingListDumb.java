import java.util.*;

public class ShoppingList {

    HashMap<String, HashMap<String, Integer>> available;
    HashMap<String, HashMap<String, Integer>> recipe;

    public ShoppingList() {
        available = new HashMap<>();
        recipe = new HashMap<>();
    }

    public void read() {
        Scanner s = new Scanner(System.in);
        String ingredient;

        String pointer = "AVAILABLE";

        String name;
        int amount;
        String unit;

        while (s.hasNext()) {
            ingredient = s.nextLine();
            String[] ingredientSplit = ingredient.split(" ");

            if (ingredientSplit[0].equals("RECIPE")) pointer = "RECIPE";
            else if (ingredient.equals("AVAILABLE")) pointer = "AVAILABLE";

            if (!ingredientSplit[0].equals("RECIPE") && !ingredient.equals("AVAILABLE")) {
                amount = Integer.parseInt(ingredientSplit[0]);
                unit = ingredientSplit[1];
                name = ingredientSplit[2];

                HashMap<String, Integer> innerMap = new HashMap<>();
                innerMap.put(unit, amount);

                if (pointer.equals("AVAILABLE")) available.put(name, innerMap);
                else recipe.put(name, innerMap);
            }
        }
        s.close();
    }

}





/*
            if (line.equals("AVAILABLE")) { line = s.nextLine(); }
                    else if (line.split(" ")[0].equals("RECIPE")) {
                    state = true;
                    line = s.nextLine();
                    }


                                if (!state) {
                createMap(ingredient, available);
            }
            if (state) {
                createMap(ingredient, recipe);





        public void read() {
        Scanner s = new Scanner(System.in);
        String ingredient = "";
        boolean state = false;

        while (s.hasNext()) {
            ingredient = s.nextLine();
            if (ingredient.equals("AVAILABLE")) ingredient = s.nextLine();
            if (ingredient.split(" ")[0].equals("RECIPE")) ingredient = s.nextLine();


            makeList(ingredient, available);

            System.out.println(ingredient);
        }
        printTest();
    }


    private void makeList(String ingredient, HashMap IngredientMap) {
        String[] list = ingredient.split(" ");

        IngredientMap.put(
                list[2],
                list[0]
        );

    }

    private void createMap(String ingredient, HashMap ingredientMap) {
        String[] ingredientSplit = ingredient.split(" ");
        ingredientMap.put(ingredientSplit[2], Integer.valueOf(ingredientSplit[0]));
    }

    private void printTest() {
        System.out.println("Available: " + available);
        System.out.println("Recipe: " + available);
    }
}
 */