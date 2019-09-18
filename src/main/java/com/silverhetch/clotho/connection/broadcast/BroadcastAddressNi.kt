package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source
import java.net.InetAddress
import java.net.NetworkInterface

/**
 * Broadcast address source for Network interface.
 *
 * Note that this method may returns null.
 */
class BroadcastAddressNi(private val networkInterface: NetworkInterface) : Source<InetAddress?> {
    override fun value(): InetAddress? {
        val list = networkInterface.interfaceAddresses
        list.forEach {
            if (it.broadcast != null) {
                return it.broadcast
            }
        }
        return null
    }
}