package com.silverhetch.clotho.connection.broadcast

import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

class TargetImpl(private val networkInterface: NetworkInterface,
                 private val inetAddress: InetAddress) : Target {
    override fun name(): String {
        return networkInterface.displayName
    }

    override fun interfaceInetAddress(): InetAddress {
        val addresses = networkInterface.interfaceAddresses
        addresses.forEach {
            if (it.address is Inet4Address) {
                return it.address
            }
        }
        return InetAddress.getByName("127.0.0.1")
    }

    override fun broadcastAddress(): InetAddress {
        return inetAddress
    }
}