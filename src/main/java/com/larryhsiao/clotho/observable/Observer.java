package com.larryhsiao.clotho.observable;

/**
 * Observer object for Observable.
 *
 * @param <T> The type of observable.
 */
public interface Observer<T> {
    /**
     * Invoked when data updated.
     *
     * @param observable original observable object.
     * @param data       the new data.
     */
    void onUpdate(Observable<T> observable, T data);
}
