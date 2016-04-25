package com.example.myq.mylibrary;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式化
 */
public class DateFormatUtils {
    public static final String PATTERN_YMDHMS = "yyyyMMdd HH:mm:ss";
    public static final String PATTERN_YMDHM = "yyyyMMdd HH:mm";
    public static final String PATTERN_YMD = "yyyyMMdd";
    public static final String PATTERN_MD = "MM月dd日";
    public static final String PATTERN_HMS = "HH:mm:ss";
    public static final String PATTERN_HM = "HH:mm";

    public static String getCurrentTime() {
        return getCurrentTime(PATTERN_YMDHMS);
    }

    public static String getCurrentTime(String pattern) {
        return format(pattern, new Date());
    }

    public static String formatLong(String pattern, String timeMillions) {
        long millions;
        try {
            millions = Long.parseLong(timeMillions);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return timeMillions;
        }
        return new SimpleDateFormat(pattern, Locale.CHINESE).format(new Date(millions));
    }


    /**
     * 今天则显示
     *
     * @param timeMillions
     * @return
     */
    public static String formatStepTime(String timeMillions) {
        Date stepDate = new Date(Long.parseLong(timeMillions));
        String stepDateMD = format(PATTERN_MD, stepDate);
        if (!TextUtils.equals(stepDateMD, format(PATTERN_MD, new Date())))
            return stepDateMD;
        return new SimpleDateFormat(PATTERN_HM, Locale.CHINESE).format(stepDate);
    }

    public static String format(String pattern, Date date) {
        return new SimpleDateFormat(pattern, Locale.CHINESE).format(date);
    }

    public static Date formatStrDate(String pattern, String time) {
        try {
            return new SimpleDateFormat(pattern, Locale.CHINA).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long formatStrTimeToLong(String pattern, String time) {
        Date date = formatStrDate(pattern, time);
        if (date == null) {
            return 0;
        }
        return date.getTime();
    }
}
