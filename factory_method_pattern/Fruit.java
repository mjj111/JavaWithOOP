package factory_method_pattern;

public class Fruit {
    protected Integer weight;

    public Fruit(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return this.weight;
    }
}