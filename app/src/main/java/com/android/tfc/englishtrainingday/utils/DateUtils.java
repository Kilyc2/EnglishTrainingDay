package com.android.tfc.englishtrainingday.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static String[] dayOfWeek = {"Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat"};

    public static String getDateFormatYYYYMMDD(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    public static String getTodayFormatYYYYMMDD() {
        return getDateFormatYYYYMMDD(new Date());
    }


    public static Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPreviousDate(String date, int daySubtract) {
        Date dt = getDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -daySubtract);
        dt = c.getTime();
        return getDateFormatYYYYMMDD(dt);
    }

    public static int getDayOfWeek(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(getDate(date));
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static String getTextDayOfWeek(int day) throws IllegalArgumentException {
        if (day > 7)
            throw new IllegalArgumentException("Index of bounds");
        return dayOfWeek[day - 1];
    }
}