package com.larryhsiao.clotho.serialization;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link GsonJson}.
 */
public class GsonJsonTest {
    private static class Target {
        public final String field1;
        public final String field2;

        private Target(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }

    /**
     * Serialization to Json.
     */
    @Test
    public void serialization() {
        Assert.assertEquals(
            "{\"field1\":\"field1\",\"field2\":\"field2\"}",
            new GsonJson().serialize(new Target("field1", "field2"), Target.class)
        );
    }

    /**
     * Deserialization from json string.
     */
    @Test
    public void deserialization() {
        Assert.assertEquals(
            "field1",
            new GsonJson().deserialize(
                "{\"field1\":\"field1\",\"field2\":\"field2\"}",
                Target.class
            ).field1
        );
    }
}