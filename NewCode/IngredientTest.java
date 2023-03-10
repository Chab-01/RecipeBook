import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class IngredientTest {
    @Test
    public void testSetPrice(){
        Ingredient ingredient = new Ingredient();
        double expected = 10.0;
        ingredient.setPrice(expected);

        assertEquals(expected, ingredient.getPrice(), 0);
        
    }

    @Test
    public void testSetMeasure(){
        Ingredient ingredient = new Ingredient(); 
        String expected = "litre";
        ingredient.setMeasure(expected);

        assertEquals(expected, ingredient.getMeasure());
        
    }
    
    @Test
    public void testSetName(){
        Ingredient ingredient = new Ingredient(); 
        String expected = "kaka";
        ingredient.setName(expected);

        assertEquals(expected, ingredient.getName());
        
    }
}
