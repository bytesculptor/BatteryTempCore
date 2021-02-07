/*
 * Copyright (c) 2017 - 2021  Byte Sculptor Software  - All Rights Reserved
 *
 * All information contained herein is and remains the property of Byte Sculptor Software.
 * Unauthorized copying of this file, via any medium, is strictly prohibited unless prior
 * written permission is obtained from Byte Sculptor Software.
 *
 * Romeo Rondinelli - bytesculptor@gmail.com
 *
 */

package com.bytesculptor.batterytempcore.utilities;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;


public class LocalLibrary {

    /*
     *  convert to Fahrenheit and return rounded to one decimal
     */
    public static double convertToFahrenheit(double fCelsius) {
        return Math.round((fCelsius * 1.8 + 32.0) * 10) / 10.0;
    }

    public static double convertToCelsius(double fFahrenheit) {
        return Math.round(((fFahrenheit - 32.0) / 1.8) * 10) / 10.0;
    }

    public static String getTimestampAsDateString(long timestamp) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(timestamp);
    }

    public static String getTimestampAsTimeString(long timestamp) {
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
        return dateFormat.format(timestamp);
    }

    public static String getTimestampAsDateTime(long timestamp) {
        return getTimestampAsDateString(timestamp) + " - " + getTimestampAsTimeString(timestamp);
    }

    public static int getWeekDay(long timestamp) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(timestamp);
            return cal.get(Calendar.DAY_OF_WEEK);
        } catch (Exception e) {
            return 0;
        }
    }


    /*
    public static String getTimestampAsShortDateString(long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        String str1 = DateFormat.getDateInstance(DateFormat., Locale.getDefault()).format(timestamp);
        return dateFormat.format(timestamp);
    }
    */
}
