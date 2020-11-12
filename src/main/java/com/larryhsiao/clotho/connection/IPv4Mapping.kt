package com.larryhsiao.clotho.connection

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.regex.IsIPv4
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.net.UnknownHostException

/**
 * Source to build IPv4 address which current machine have.
 */
class IPv4Mapping : Source<Map<String, InetAddress>> {
    override fun value(): Map<String, InetAddress> {
        return try {
            getPublicIPv4()
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            mapOf()
        }
    }

    @Throws(UnknownHostException::class, SocketException::class)
    private fun getPublicIPv4(): Map<String, InetAddress> {
        val result = HashMap<String, InetAddress>()
        val e = NetworkInterface.getNetworkInterfaces()
        while (e.hasMoreElements()) {
            val n = e.nextElement()
            val ee = n.inetAddresses
            while (ee.hasMoreElements()) {
                val i = ee.nextElement()
                val currentAddress = i.hostAddress
                if (!i.isLoopbackAddress && IsIPv4(currentAddress).value()) {
                    result[n.displayName] = i
                }
            }
        }
        return result
    }
}