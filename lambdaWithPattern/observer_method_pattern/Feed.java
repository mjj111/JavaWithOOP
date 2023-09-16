package observer_method_pattern;

import java.util.*;

public class Feed implements Subject{
    private final List<Observer> observers = new ArrayList<>();
    public void registerObserver(Observer o){
        this.observers.add(o);
    }
    public void notifyObservers(String tweet){
        observers.forEach(o->o.notify(tweet));
    }

}
