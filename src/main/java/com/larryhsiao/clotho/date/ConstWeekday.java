package com.larryhsiao.clotho.date;

/**
 * Constant version of {@link Weekday}.
 */
public class ConstWeekday implements Weekday {
    private final String name;

    public ConstWeekday(String name) {this.name = name;}

    @Override
    public String name() {
        return name;
    }
}
