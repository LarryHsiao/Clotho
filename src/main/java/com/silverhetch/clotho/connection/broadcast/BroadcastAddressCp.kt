package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source
import java.net.InetAddress
import java.net.NetworkInterface

/**
 * Broadcast address for this computer
 */
class BroadcastAddressCp : Source<List<InetAddress>> {
    override fun value(): List<InetAddress> {
        val result = ArrayList<InetAddress>()
        val nis = NetworkInterface.getNetworkInterfaces()
        while (nis.hasMoreElements()) {
            BroadcastAddressNi(nis.nextElement()).value()?.run {
                result.add(this)
            }
        }
        return result
    }
}