package factory_method_pattern;

public class FruitFactory {
    public Fruit createFruit(String type, Integer weight) {
        switch (type) {
            case "Apple":
                return new Apple(weight);
            case "Banana":
                return new Banana(weight);
            case "Orange":
                return new Orange(weight); 
            default:
                throw new IllegalArgumentException("Unknown fruit type: " + type);
        }
    }
}
