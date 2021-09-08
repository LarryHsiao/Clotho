package com.larryhsiao.clotho.comparator;

import java.text.Collator;
import java.util.Comparator;

/**
 * String comparator for sorting String in non-ASCII format.
 */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Collator.getInstance().compare(o1, o2);
    }
}
