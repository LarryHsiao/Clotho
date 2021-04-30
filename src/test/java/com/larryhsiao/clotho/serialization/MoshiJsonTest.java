package com.larryhsiao.clotho.serialization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
;

/**
 * Test for {@link MoshiJson}.
 */
public class MoshiJsonTest {
    private static class Target {
        public final String field1;
        public final String field2;

        private Target(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }

    /**
     * Normal case of serialization.
     */
    @Test
    public void serialization() {
        Assertions.assertEquals(
            "{\"field1\":\"field1\",\"field2\":\"field2\"}",
            new MoshiJson().serialize(new Target("field1", "field2"), Target.class)
        );
    }


    /**
     * Deserialization from json string.
     */
    @Test
    public void deserialization() {
        Assertions.assertEquals(
            "field1",
            new MoshiJson().deserialize(
                "{\"field1\":\"field1\",\"field2\":\"field2\"}",
                Target.class
            ).field1
        );
    }
}
