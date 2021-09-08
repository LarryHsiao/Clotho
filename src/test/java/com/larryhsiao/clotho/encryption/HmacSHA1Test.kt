package com.larryhsiao.clotho.encryption

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.dgist.HexString
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HmacSHA1Test {
    @Test
    fun simple() {
        Assertions.assertEquals(
            "565a8e07219d855978015554920f01856470e158",
            HexString(
                HmacSHA1(
                    object : Source<ByteArray> {
                        override fun value(): ByteArray {
                            return "ABC".toByteArray()
                        }
                    }, "ThisIsSecretKey"
                ).value()
            ).value()
        )
    }
}