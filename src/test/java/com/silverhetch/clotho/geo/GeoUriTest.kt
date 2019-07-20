package com.silverhetch.clotho.geo

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for com.silverhetch.clotho.geo.GeoUri
 */
class GeoUriTest {
    @Test
    fun coordinatorOnly() {
        assertEquals(
            "geo:20.0,121.0",
            GeoUri(
                121.0,
                20.0
            ).value().toASCIIString()
        )
    }

    @Test
    fun additionalCrs() {
        assertEquals(
            "geo:20.0,121.0;crs=EPSG:32718",
            GeoUri(
                121.0,
                20.0,
                "EPSG:32718"
            ).value().toASCIIString()
        )
    }

    @Test
    fun additionalUncertainly() {
        assertEquals(
            "geo:20.0,121.0;u=10",
            GeoUri(
                121.0,
                20.0,
                u = 10
            ).value().toASCIIString()
        )
    }


    @Test
    fun allParameter() {
        assertEquals(
            "geo:20.0,121.0;crs=WGS-84;u=10",
            GeoUri(
                121.0,
                20.0,
                "WGS-84",
                10
            ).value().toASCIIString()
        )
    }
}