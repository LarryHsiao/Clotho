package com.silverhetch.clotho.connection.broadcast

import java.net.InetAddress
import java.net.NetworkInterface

interface Target {
    fun networkInterface(): NetworkInterface
    fun broadcastAddress(): InetAddress
}