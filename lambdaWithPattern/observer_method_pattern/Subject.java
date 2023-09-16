package observer_method_pattern;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
