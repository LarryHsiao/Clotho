package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source

/**
 * Source for first broadcast ip address that we can found
 *
 * Note: This method may returns null which we can not avoid for now
 */
class BroadcastAddressFirst : Source<Target?> {
    override fun value(): Target? {
        BroadcastAddressCp().value().forEach {
            return it
        }
        return null
    }
}