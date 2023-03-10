public class SearchFactory {
    public SearchStrategy searchByName(String name){
        return new SearchByNameStrategy(name);
    }

    public SearchStrategy searchByPrice(double price){
        return new SearchByPriceStrategy(price);
    }
}
