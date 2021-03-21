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
package com.bytesculptor.batterytempcore.utilities

import android.content.Context
import com.bytesculptor.batterytempcore.R
import java.text.DateFormat
import java.util.*


object ConversionHelpers {
    /*
     *  convert to Fahrenheit and return rounded to one decimal
     */
    @JvmStatic
    fun convertToFahrenheit(fCelsius: Double): Double {
        return Math.round((fCelsius * 1.8 + 32.0) * 10) / 10.0
    }

    @JvmStatic
    fun convertToCelsius(fFahrenheit: Double): Double {
        return Math.round((fFahrenheit - 32.0) / 1.8 * 10) / 10.0
    }

    fun getTimestampAsDateString(timestamp: Long): String {
        val dateFormat = DateFormat.getDateInstance()
        return dateFormat.format(timestamp)
    }

    fun getTimestampAsDateStringWithoutYear(timestamp: Long): String {
        val dateFormat = DateFormat.getDateInstance()



        return dateFormat.format(timestamp)
    }

    @JvmStatic
    fun getTimestampAsTimeString(timestamp: Long): String {
        val dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault())
        return dateFormat.format(timestamp)
    }

    fun getTimestampAsDateTime(timestamp: Long): String {
        return getTimestampAsDateString(timestamp) + " - " + getTimestampAsTimeString(timestamp)
    }

    fun getWeekDay(timestamp: Long): Int {
        return try {
            val cal = Calendar.getInstance()
            cal.timeInMillis = timestamp
            cal[Calendar.DAY_OF_WEEK]
        } catch (e: Exception) {
            0
        }
    }

    fun getWeekdayString(context: Context, timestamp: Long): String {
        return when (ConversionHelpers.getWeekDay(timestamp)) {
            1 -> context.getString(R.string.Mon)
            2 -> context.getString(R.string.Tue)
            3 -> context.getString(R.string.Wed)
            4 -> context.getString(R.string.Thu)
            5 -> context.getString(R.string.Fri)
            6 -> context.getString(R.string.Sat)
            7 -> context.getString(R.string.Sun)
            else -> "---"
        }
    }
}