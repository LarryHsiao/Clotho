package com.larryhsiao.clotho.observable;

/**
 * Represent observable object.
 * @param <T> Type of observable observes.
 */
public interface Observable <T>{
    /**
     * @return value this object keeps
     */
    T value();

    /**
     * @param observer observe this object with {@link Observer}
     */
    void addObserver(Observer<T> observer);

    /**
     * @param observer remove the observer reference
     */
    void removeObserver(Observer<T> observer);

    /**
     * Remove all observers
     */
    void clearAllObserver();
}
