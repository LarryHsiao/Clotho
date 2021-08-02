package com.larryhsiao.clotho.color;

import com.larryhsiao.clotho.Source;

/**
 * Calculate the Luminance of color.
 * <p>
 * Calculate by formula CCIR 601(ITU-R Recommendation BT.601)
 */
public class LuminanceByColor implements Source<Double> {
    private final long color;

    public LuminanceByColor(long color) {this.color = color;}

    /**
     * The luminance is between 1.0-0.0, lightest is 1.0, otherwise 0.0
     */
    @Override
    public Double value() {
        return (0.299 * new RedInt(color).value() +
            0.587 * new GreenInt(color).value() +
            0.114 * new BlueInt(color).value()) / 255;
    }
}
