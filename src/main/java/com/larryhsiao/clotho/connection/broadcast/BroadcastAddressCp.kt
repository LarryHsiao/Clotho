package com.larryhsiao.clotho.connection.broadcast

import com.larryhsiao.clotho.Source
import java.net.NetworkInterface

/**
 * Broadcast address for this computer
 */
class BroadcastAddressCp : Source<List<Target>> {
    override fun value(): List<Target> {
        val result = ArrayList<Target>()
        val nis = NetworkInterface.getNetworkInterfaces()
        while (nis.hasMoreElements()) {
            val networkInterface = nis.nextElement()
            BroadcastAddressNi(networkInterface).value()?.run {
                result.add(
                    TargetImpl(
                        networkInterface,
                        this
                    )
                )
            }
        }
        return result
    }
}