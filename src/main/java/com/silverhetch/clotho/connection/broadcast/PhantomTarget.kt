package com.silverhetch.clotho.connection.broadcast

import java.net.InetAddress

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