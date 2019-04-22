package com.silverhetch.clotho.observable

/**
 * Wrapper class for [Observable].
 */
class ObservableWrapper<T>(private val observable: Observable<T>) : Observable<T> {
    override fun value(): T {
        return observable.value()
    }

    override fun addObserver(observer: Observer<T>?) {
        observable.addObserver(observer)
    }

    override fun removeObserver(observer: Observer<T>?) {
        observable.removeObserver(observer)
    }

    override fun clearAllObserver() {
        observable.clearAllObserver()
    }
}