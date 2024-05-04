package com.zeon.ecommerce.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.text.ParseException;

public class DateUtil {
    public static Date covertDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        //formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return formatter.parse(date);
    }
}
