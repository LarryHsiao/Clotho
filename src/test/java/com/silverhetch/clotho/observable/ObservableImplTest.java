package com.silverhetch.clotho.observable;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class ObservableImplTest {
    @Test
    public void notifyObservers() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        observableImpl.addObserver((observableImpl1, data) -> {
            hasUpdate.set(true);
            assertEquals("Update", data);
        });
        observableImpl.notifyObservers("Update");
        assertTrue(hasUpdate.get());
    }

    @Test
    public void removeObserver() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        Observer<String> observer = (observableImpl1, data) -> hasUpdate.set(true);
        observableImpl.addObserver(observer);
        observableImpl.removeObserver(observer);
        observableImpl.notifyObservers("Update");
        assertFalse(hasUpdate.get());
    }

    @Test
    public void hasValueChanged() {
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        observableImpl.notifyObservers("Update");
        assertEquals("Update", observableImpl.value());
    }
}