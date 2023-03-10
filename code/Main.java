
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        RecipeBook recipebook = new RecipeBook(storage.readIngredients());
        Console console = new Console(recipebook);
        console.start();
        storage.writeIngredients(recipebook.getIngredients());
        storage.writeRecipes(recipebook.getRecipes());
    }

}
