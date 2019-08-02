package com.silverhetch.clotho.observable

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Tests for [com.silverhetch.clotho.observable.ObservableWrapper].
 */
class ObservableWrapperTest{
    /**
     * It works using wrapped instance for addObserver
     */
    @Test
    @Throws(Exception::class)
    fun notifyObservers() {
        val hasUpdate = AtomicBoolean(false)
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        wrapped.addObserver { observableImpl1, data ->
            hasUpdate.set(true)
            assertEquals("Update", data)
        }
        observableImpl.notifyObservers("Update")
        assertTrue(hasUpdate.get())
    }

    /**
     * Check there has no changes after remove observer.
     */
    @Test
    fun removeObserver() {
        val hasUpdate = AtomicBoolean(false)
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        val observer = Observer<String> { observableImpl1, data -> hasUpdate.set(true) }
        wrapped .addObserver(observer)
        wrapped .removeObserver(observer)
        observableImpl.notifyObservers("Update")
        assertFalse(hasUpdate.get())
    }

    @Test
    fun hasValueChanged() {
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        observableImpl.notifyObservers("Update")
        assertEquals("Update", wrapped.value())
    }
    /**
     * Check there has no change after clear observers.
     */
    @Test
    fun clearObserver() {
        val hasUpdate = AtomicBoolean(false)
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        val observer = Observer<String> { observableImpl1, data -> hasUpdate.set(true) }
        wrapped.addObserver(observer)
        wrapped.clearAllObserver()
        observableImpl.notifyObservers("New")
        assertFalse(hasUpdate.get())
    }
}