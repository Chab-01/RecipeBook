import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        List < Ingredient > ingredients = storage.readIngredients();
        List < Recipe > recipes = storage.readRecipes(ingredients);
        RecipeBook recipebook = new RecipeBook(ingredients, recipes);
        Console console = new Console(recipebook);
        console.start();
        storage.writeIngredients(recipebook.getIngredients());
        storage.writeRecipes(recipebook.getRecipes());
    }

}
