package ca.ualberta.cs.lonelytwitter;

public interface MyObservable {
    void notifyObservers();
    void addObserver(MyObserver o);


}
