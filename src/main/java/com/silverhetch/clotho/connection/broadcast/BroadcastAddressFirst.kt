package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source
import java.net.InetAddress

/**
 * Source for first broadcast ip address that we can found
 *
 * Note: This method may returns null which we can not avoid for now
 */
class BroadcastAddressFirst : Source<InetAddress?> {
    override fun value(): InetAddress? {
        return BroadcastAddressCp().value()[0]
    }
}