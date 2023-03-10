public class RecipeIngredient {
    private Ingredient ingredient;
    private int amount;

    public void setIngredient(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public Ingredient getIngredient(){
        return ingredient;
    }
    public int getAmount() {
        return amount;
    }

}
