package com.silverhetch.clotho.connection.broadcast

import java.net.InetAddress
import java.net.NetworkInterface

/**
 *
 */
interface Target {
    fun name(): String
    fun interfaceInetAddress(): InetAddress
    fun broadcastAddress(): InetAddress
}