package com.silverhetch.clotho.utility.comparator

import java.text.Collator

class StringComparator(private val reversed: Boolean = false) : Comparator<String> {
    override fun compare(o1: String?, o2: String?): Int {
        return if (reversed) {
            Collator.getInstance().compare(o1, o2)
        } else {
            Collator.getInstance().compare(o2, o1)
        }
    }
}