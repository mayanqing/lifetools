package com.example.myq.mylibrary;

import java.math.BigDecimal;

/**
 *
 */
public class DecimalFormatUtils {

    /**
     * 保留几位小数
     *
     * @param value
     * @param newScale
     * @return
     */
    public static String format(String value, int newScale) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(newScale,BigDecimal.ROUND_HALF_UP).toString();
    }
}
