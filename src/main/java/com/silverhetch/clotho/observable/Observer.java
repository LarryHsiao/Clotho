package com.silverhetch.clotho.observable;

public interface Observer<T> {
    void onUpdate(Observable<T> observable, T data);
}
