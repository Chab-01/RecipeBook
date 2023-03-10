public class Ingredient {
    private String name;
    private String measure;
    private double price;
    RecipeBook recipeBook;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }

}
