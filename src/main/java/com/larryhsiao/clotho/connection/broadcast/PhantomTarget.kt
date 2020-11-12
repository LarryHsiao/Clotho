package com.larryhsiao.clotho.connection.broadcast

import java.net.InetAddress

/**
 * Phantom object Of [Target]
 */
class PhantomTarget : Target {
    override fun name(): String {
        return "PhantomTarget"
    }

    override fun interfaceInetAddress(): InetAddress {
        return InetAddress.getByName("127.0.0.1")
    }

    override fun broadcastAddress(): InetAddress {
        return InetAddress.getByName("127.0.0.1")
    }
}