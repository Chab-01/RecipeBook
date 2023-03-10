import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private RecipeBook recipeBook;
    private Scanner scanner = new Scanner(System.in);
    private SearchFactory searchFactory = new SearchFactory();

    public Console(RecipeBook recipebook) {
        this.recipeBook = recipebook;

    }

    public void start() {
        showMenu();
        int option = readOption();
        if (option == 1) {
            showIngredients();
        } else if (option == 2) {
            addIngredient();
        } else if (option == 3) {
            deleteIngredient();
        } else if (option == 4) {
            showIngredient();
        } else if (option == 5) {
            showRecipes();
        } else if (option == 6) {
            showRecipe();
        } else if (option == 7) {
            deleteRecipe();
        } else if (option == 8) {
            addRecipe();
        } else if (option == 9) {
            searchByName();
        } else if (option == 10) {
            searchByPrice();
        } else if (option == 0) {
            return;
        } else {
            System.out.println("Wrong input");
        }
        start();

    }

    private void showMenu() {
        System.out.println("Welcome to cooking (Enter 0 to exit)");
        System.out.println("1: Show all ingredients");
        System.out.println("2: Add ingredeient");
        System.out.println("3: Delete ingredients");
        System.out.println("4: Show ingredient");
        System.out.println("5: Show all recipes");
        System.out.println("6: Show recipe");
        System.out.println("7: Delete recipe");
        System.out.println("8: Add recipe");
        System.out.println("9: Search by name");
        System.out.println("10: Search by max price");

    }

    private int readOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private double readDouble() {
        double option = scanner.nextDouble();
        scanner.nextLine();
        return option;
    }

    private String readMeasure() {
        String option = scanner.nextLine();
        return option;
    }

    private String readLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private void showIngredients() {
        List<Ingredient> ingredients = recipeBook.getIngredients();
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(ingredients.get(i).getName());
        }

    }

    private void addIngredient() { // splitta bort kolon och konvertera till string string double
        System.out.println("2: Add an ingredient: ");
        String name = scanner.nextLine();
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        System.out.println("Write the price: ");
        ingredient.setPrice(readDouble());
        System.out.println("Write a measurement");
        ingredient.setMeasure(readMeasure());
        recipeBook.addIngredient(ingredient);

    }

    private void showIngredient() { // iterara genom listan och printa ut innehållet
        System.out.println("Write name of ingredient");
        String name = scanner.nextLine();
        Ingredient ingredient = recipeBook.findIngredient(name);
        if (ingredient != null) {
            System.out.println(ingredient.getName());
        }

    }

    private void deleteIngredient() {
        System.out.println("Enter name of ingredient to delete");
        String searchedName = scanner.nextLine();
        recipeBook.deleteIngredient(searchedName);

    }

    private void showRecipes() {
        List<Recipe> recipes = recipeBook.getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(recipes.get(i).getName());
        }

    }

    private void addRecipe() { // splitta bort kolon och konvertera till string string double
        System.out.println("2: Add a recipe: ");
        String name = scanner.nextLine();
        Recipe recipe = new Recipe();
        recipe.setName(name);
        addPortionsToRecipe(recipe);
        addIngredientToRecipe(recipe);
        addInstructionToRecipe(recipe);
        addCommentsToRecipe(recipe);
        recipeBook.addRecipe(recipe);

    }

    private void addIngredientToRecipe(Recipe recipe) {
        while (true) {
            String name = readLine("Write ingredient name");
            if (name.equals("0")) {
                break;
            }
            Ingredient ingredient = recipeBook.findIngredient(name);
            if (ingredient != null) {
                int amount = readOption();
                recipe.addIngredient(ingredient, amount);
            } else {
                System.out.println("");
            }
        }

    }

    private void addPortionsToRecipe(Recipe recipe) {
        System.out.println("Add number of portions");
        recipe.setPortions(readOption());

    }

    private void addCommentsToRecipe(Recipe recipe) {
        while (true) {
            String name = readLine("Add comments (Enter 0 to break): ");
            if (name.equals("0")) {
                break;
            }
            recipe.addComments(name);
        }
 
    }

    private void addInstructionToRecipe(Recipe recipe) {
        while (true) {
            String name = readLine("Add instructions (Enter 0 to break): ");
            if (name.equals("0")) {
                break;
            }
            recipe.addInstruction(name);
        }
    }

    private void showRecipe() { // iterara genom listan och printa ut innehållet
        System.out.println("Write name of recipe");
        String name = scanner.nextLine();
        List<String> ingredientNames = new ArrayList<>();
        Recipe recipe = recipeBook.findRecipe(name);
        if (recipe != null) {
            System.out.println(recipe.getName());
            for (int i = 0; i < recipe.getIngredients().size(); i++) {
                RecipeIngredient ingredient = recipe.getIngredients().get(i);
                ingredientNames.add(ingredient.getIngredient().getName());
            }
            System.out.println(ingredientNames);

            System.out.println(recipe.getComments());
            System.out.println(recipe.getInstructions());
            System.out.println(recipe.getPortions());
        }

    }

    private void deleteRecipe() {
        System.out.println("Enter name of recipe to delete");
        String searchedName = scanner.nextLine();
        recipeBook.deleteRecipe(searchedName);

    }
    private void searchByName(){
        String name = readLine("Write ingredient name: ");
        SearchStrategy strategy = searchFactory.searchByName(name);
        List <Recipe> recipes = strategy.search(recipeBook.getRecipes());
        for (Recipe recipe: recipes ){
            System.out.println(recipe.getName());
        }
    }
    private void searchByPrice(){
        System.out.println("Write price");
        double price = readDouble();
        SearchStrategy strategy = searchFactory.searchByPrice(price);
        List <Recipe> recipes = strategy.search(recipeBook.getRecipes());
        for (Recipe recipe: recipes ){
            System.out.println(recipe.getName());
        }
    }
}