package com.silverhetch.clotho.observable;

import java.util.LinkedList;
import java.util.List;

public class Observable<T> {
    private final List<Observer<T>> observers = new LinkedList<>();

    public void addObserver(Observer<T> observer) {
        if (observers.contains(observer)) {
            return;
        }
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T data) {
        for (Observer<T> observer : observers) {
            observer.onUpdate(this, data);
        }
    }
}
