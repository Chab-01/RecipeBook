import java.util.ArrayList;
import java.util.List;

public class SearchByPriceStrategy implements SearchStrategy {
    private double price;
    public SearchByPriceStrategy(double price){
        this.price = price;
    }
    @Override
    public List<Recipe> search(List<Recipe> recipes) {
        List<Recipe> result = new ArrayList<>();
        for(Recipe recipe: recipes){
            if (recipe.getPrice()<= price){
                
                result.add(recipe);
            }
        }
        return result;
    }

    
}
