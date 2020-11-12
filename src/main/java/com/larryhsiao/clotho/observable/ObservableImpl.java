package com.larryhsiao.clotho.observable;

import java.util.LinkedList;
import java.util.List;

public class ObservableImpl<T> implements Observable<T> {
    private final List<Observer<T>> observers = new LinkedList<>();
    protected T value;

    public ObservableImpl(T initial) {
        this.value = initial;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public void addObserver(Observer<T> observer) {
        if (observers.contains(observer)) {
            return;
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void clearAllObserver() {
        observers.clear();
    }

    public void notifyObservers(T data) {
        this.value = data;
        for (Observer<T> observer : observers) {
            observer.onUpdate(this, data);
        }
    }
}
