package com.larryhsiao.clotho.observable

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Tests for [com.larryhsiao.clotho.observable.ObservableWrapper].
 */
class ObservableWrapperTest {
    companion object {
        private const val INPUT_DATA = "update"
    }

    /**
     * It works using wrapped instance for addObserver
     */
    @Test
    @Throws(Exception::class)
    fun notifyObservers() {
        val hasUpdate = AtomicBoolean(false)
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        wrapped.addObserver { _, data ->
            hasUpdate.set(true)
            assertEquals(INPUT_DATA, data)
        }
        observableImpl.notifyObservers(INPUT_DATA)
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
        val observer = Observer<String> { _, _ -> hasUpdate.set(true) }
        wrapped.addObserver(observer)
        wrapped.removeObserver(observer)
        observableImpl.notifyObservers(INPUT_DATA)
        assertFalse(hasUpdate.get())
    }

    /**
     * Check the value changed using wrapped object.
     */
    @Test
    fun hasValueChanged() {
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        observableImpl.notifyObservers(INPUT_DATA)
        assertEquals(INPUT_DATA, wrapped.value())
    }

    /**
     * Check there has no change after clear observers.
     */
    @Test
    fun clearObserver() {
        val hasUpdate = AtomicBoolean(false)
        val observableImpl = ObservableImpl("")
        val wrapped = ObservableWrapper(observableImpl)
        val observer = Observer<String> { _, _ -> hasUpdate.set(true) }
        wrapped.addObserver(observer)
        wrapped.clearAllObserver()
        observableImpl.notifyObservers("New")
        assertFalse(hasUpdate.get())
    }
}