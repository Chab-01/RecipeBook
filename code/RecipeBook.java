import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Recipe> recipes = new ArrayList<Recipe>();
    public RecipeBook(List <Ingredient> ingredients){
        this.ingredients = ingredients;
    }


    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Ingredient findIngredient(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }

    public Ingredient findPrice(Double price) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getPrice().equals(price)) {
                return ingredient;
            }
        }
        return null;
    }
    public void deleteIngredient(String searchName) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getName().equals(searchName)) {
                ingredients.remove(i);
                return; 
            }
        }

    }
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    public Recipe findRecipe(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }

    public void deleteRecipe(String searchName) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getName().equals(searchName)) {
                recipes.remove(i);
                return; 
            }
        }

    }
    public List <Ingredient> getIngredients(){
        return new ArrayList<Ingredient>(ingredients);
    }
    
    public List <Recipe> getRecipes(){
        return new ArrayList<Recipe>(recipes);
    }



}
