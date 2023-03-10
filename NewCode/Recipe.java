import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
    private List<String> instructions = new ArrayList<String>();
    private List<String> comments = new ArrayList<String>();
    private int portions;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addIngredient(Ingredient ingredient, int amount) {
        RecipeIngredient ri = new RecipeIngredient();
        ri.setIngredient(ingredient);
        ri.setAmount(amount);
        ingredients.add(ri);
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getPortions(){
        return portions;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public void addComments(String comment) {
        comments.add(comment);

    }

    public double getPrice() {
        double price = 0;
        for (RecipeIngredient ri : ingredients) {
            price += ri.getIngredient().getPrice() * ri.getAmount();

        }
        return price;
    }
    public boolean hasIngredient(String name){
        for (RecipeIngredient ri : ingredients) {
            if(ri.getIngredient().getName().equals(name)){
                return true;
            }
        } return false;
    }

}
