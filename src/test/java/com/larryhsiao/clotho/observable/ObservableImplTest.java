package com.larryhsiao.clotho.observable;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class ObservableImplTest {
    @Test
    public void notifyObservers() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        observableImpl.addObserver(new Observer<String>() {
            @Override
            public void onUpdate(Observable<String> observableImpl1, String data) {
                hasUpdate.set(true);
                assertEquals("Update", data);
            }
        });
        observableImpl.notifyObservers("Update");
        assertTrue(hasUpdate.get());
    }

    /**
     * Check there has no changes after remove observer.
     */
    @Test
    public void removeObserver() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onUpdate(Observable<String> observableImpl1, String data) {
                hasUpdate.set(true);
            }
        };
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

    /**
     * Check there has no change after clear observers.
     */
    @Test
    public void clearObserver() {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        ObservableImpl<String> observableImpl = new ObservableImpl<>("");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onUpdate(Observable<String> observableImpl1, String data) {
                hasUpdate.set(true);
            }
        };
        observableImpl.addObserver(observer);
        observableImpl.clearAllObserver();
        observableImpl.notifyObservers("New");
        assertFalse(hasUpdate.get());
    }
}