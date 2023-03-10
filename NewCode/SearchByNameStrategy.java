import java.util.ArrayList;
import java.util.List;

public class SearchByNameStrategy implements SearchStrategy{
    private String name;
    public SearchByNameStrategy(String name){
        this.name = name;
    }

    @Override
    public List<Recipe> search(List<Recipe> recipes) {
        List<Recipe> result = new ArrayList<>();
        for(Recipe recipe: recipes){
            if (recipe.hasIngredient(name)){
                result.add(recipe);
            }
        }
        return result;
    }
    
}
