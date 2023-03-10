import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Storage {
    private String path = "";

    public List<Ingredient> readIngredients() {
        List<Ingredient> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(path + "ingredients.txt"), StandardCharsets.UTF_8)) {
            for (String line : (Iterable<String>) lines::iterator) {
                Ingredient ingredient = readIngredient(line);
                if (ingredient == null) {
                    continue;
                }
                result.add(ingredient);
            }
        } finally {
            return result;
        }
    }

    private Ingredient readIngredient(String str) {
        Ingredient ingredient = new Ingredient();
        String[] array = str.split(";");
        if (array.length != 3) {
            return null;
        }
        ingredient.setName(array[0]);
        ingredient.setMeasure(array[1]);
        ingredient.setPrice(Double.parseDouble(array[2]));
        return ingredient;
    }

    public List<Recipe> readRecipes(List<Ingredient> ingredients) {
        List<Recipe> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(path + "recipes.txt"), StandardCharsets.UTF_8)) {
            for (String line : (Iterable<String>) lines::iterator) {
                Recipe recipe = readRecipe(line, ingredients);
                if (recipe == null) {
                    continue;
                }
                result.add(recipe);
            }
        } finally {
            return result;
        }
    }

    private Recipe readRecipe(String str, List<Ingredient> ingredients) {
        Recipe recipe = new Recipe();
        String[] array = str.split(";");
        if (array.length != 5) {
            return null;
        }
        recipe.setName(array[0]);
        recipe.setPortions(Integer.parseInt(array[1]));
        String[] ris = array[2].split("#");
        for (String ri : ris) {
            String[] ril = ri.split("%");
            if (ril.length != 2) {
                continue;
            }
            String name = ril[0];
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getName().equals(name)) {
                    recipe.addIngredient(ingredient, Integer.parseInt(ril[1]));
                    break;
                }
            }
        }
        String[] recipeInstructions = array[3].split("#");
        for (String string : recipeInstructions) {
            recipe.addInstruction(string);
        }
        String[] recipeComments = array[4].split("#");
        for (String string : recipeComments) {
            recipe.addComments(string);
        }

        return recipe;
    }

    public void writeIngredients(List<Ingredient> ingredients) {
        try {
            FileWriter writer = new FileWriter(path + "ingredients.txt");
            for (Ingredient ingredient : ingredients) {
                writer.write(ingredient.getName() + ";" + ingredient.getMeasure() + ";" + ingredient.getPrice());
            }
            writer.close();
        } catch (IOException i) {

        }

    }

    public void writeRecipes(List<Recipe> recipes) {
        try {
            FileWriter writer = new FileWriter(path + "recipes.txt");
            for (Recipe recipe : recipes) {
                StringBuilder sb = new StringBuilder();
                sb.append(recipe.getName());
                sb.append(";");
                sb.append(recipe.getPortions());
                sb.append(";");
                for (RecipeIngredient ri : recipe.getIngredients()) {
                    sb.append(ri.getIngredient().getName());
                    sb.append("%");
                    sb.append(ri.getAmount());
                    sb.append("#");
                }
                sb.append(";");
                for (String str : recipe.getInstructions()) {
                    sb.append(str);
                    sb.append("#");
                }
                sb.append(";");
                for (String str : recipe.getComments()) {
                    sb.append(str);
                    sb.append("#");
                }
                writer.write(sb.toString());
            }
            writer.close();
        } catch (IOException i) {

        }

    }
}