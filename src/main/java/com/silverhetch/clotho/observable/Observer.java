package com.silverhetch.clotho.observable;

public interface Observer<T> {
    void onUpdate(ObservableImpl<T> observableImpl, T data);
}
