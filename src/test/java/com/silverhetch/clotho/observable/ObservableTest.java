package com.silverhetch.clotho.observable;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class ObservableTest {
    @Test
    public void notifyObservers() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        Observable<String> observable = new Observable<>();
        observable.addObserver(new Observer<String>() {
            @Override
            public void onUpdate(Observable<String> observable, String data) {
                hasUpdate.set(true);
                assertEquals("Update", data);
            }
        });
        observable.notifyObservers("Update");
        assertTrue(hasUpdate.get());
    }

    @Test
    public void removeObserver() throws Exception {
        final AtomicBoolean hasUpdate = new AtomicBoolean(false);
        Observable<String> observable = new Observable<>();
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onUpdate(Observable<String> observable, String data) {
                hasUpdate.set(true);
            }
        };
        observable.addObserver(observer);
        observable.removeObserver(observer);
        observable.notifyObservers("Update");
        assertFalse(hasUpdate.get());
    }
}