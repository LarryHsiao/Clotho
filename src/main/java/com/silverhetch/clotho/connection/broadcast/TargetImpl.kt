package com.silverhetch.clotho.connection.broadcast

import java.net.InetAddress
import java.net.NetworkInterface

class TargetImpl(private val networkInterface: NetworkInterface,
                 private val inetAddress: InetAddress) : Target {
    override fun networkInterface(): NetworkInterface {
        return networkInterface
    }

    override fun broadcastAddress(): InetAddress {
        return inetAddress
    }
}