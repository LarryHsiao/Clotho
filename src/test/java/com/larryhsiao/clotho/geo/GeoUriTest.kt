package com.larryhsiao.clotho.geo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Test for com.larryhsiao.clotho.GeoUri
 */
class GeoUriTest {
    /**
     * Build result with latitude and longitude only
     */
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

    /**
     * Have parameters latitude, longitude and crs.
     */
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

    /**
     * Parameter latitude, longitude and uncertainly
     */
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

    /**
     * All parameter provided.
     */
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