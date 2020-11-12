package com.larryhsiao.clotho.geo

import com.larryhsiao.clotho.Source
import java.net.URI

/**
 * Source to build Geo uri(RFC 5870)
 *
 * @see https://en.wikipedia.org/wiki/Geo_URI_scheme
 *
 * @param crs Coordinate reference systems, use default(WGS-84) if this value not provided.
 * @param u Optional 'uncertainty' value, represent the uncertainty of the location in meters.
 */
class GeoUri(
    private val longitude: Double,
    private val latitude: Double,
    private val crs: String = "",
    private val u: Int = 0
) : Source<URI> {
    override fun value(): URI {
        return URI.create(StringBuilder("geo:$latitude,$longitude")
            .append(if (crs.isNotEmpty()) ";crs=$crs" else "")
            .append(if (u != 0) ";u=$u" else "")
            .toString())
    }
}