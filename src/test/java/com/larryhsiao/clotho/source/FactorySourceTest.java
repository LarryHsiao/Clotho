package com.larryhsiao.clotho.source;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorySourceTest {
    /**
     * Build different instance everytime.
     */
    @Test
    void differentReference() {
        assertNotEquals(
            new FactorySource<>(unused -> new Object()).value(),
            new FactorySource<>(unused -> new Object()).value()
        );
    }
}