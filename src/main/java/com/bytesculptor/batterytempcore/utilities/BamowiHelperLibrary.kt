/*
 * Copyright (c)  2021  Byte Sculptor Software  - All Rights Reserved
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
import android.os.BatteryManager
import android.text.format.DateUtils
import com.bytesculptor.batterytempcore.R
import com.bytesculptor.batterytempcore.model.ChargingEntity
import com.bytesculptor.batterytempcore.model.HomeViewActualValues

object BamowiHelperLibrary {

    @JvmStatic
    fun getChargingType(context: Context?, data: HomeViewActualValues): String {
        var plugType = ""
        when (data.plug) {
            0 -> plugType = "---"
            BatteryManager.BATTERY_PLUGGED_AC -> plugType = context?.getString(R.string.szPlugAC).toString()
            BatteryManager.BATTERY_PLUGGED_USB -> plugType = context?.getString(R.string.szPlugUSB).toString()
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> plugType = context?.getString(R.string.szPlugWireless).toString()
            else -> plugType = context?.getString(R.string.szPlugUnknown).toString()
        }
        return plugType
    }

    @JvmStatic
    fun getHealthText(context: Context?, health: Int): String {
        var returnString = ""
        when (health) {
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> {
                returnString = context?.getString(R.string.szBatUnknown).toString()
            }
            BatteryManager.BATTERY_HEALTH_GOOD -> {
                returnString = context?.getString(R.string.szGood).toString()
            }
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> {
                returnString = context?.getString(R.string.szBatOverheat).toString()
            }
            BatteryManager.BATTERY_HEALTH_DEAD -> {
                returnString = context?.getString(R.string.szBatDead).toString()
            }
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> {
                returnString = context?.getString(R.string.szBatOvervoltage).toString()
            }
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> {
                returnString = context?.getString(R.string.szBatUnspec).toString()
            }
            BatteryManager.BATTERY_HEALTH_COLD -> {
                returnString = context?.getString(R.string.szBatCold).toString()
            }
            else -> {
                returnString = context?.getString(R.string.szBatUnknown).toString()
            }
        }
        return returnString
    }

    @JvmStatic
    fun getHealthIcon(context: Context?, health: Int): Int {
        when (health) {
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> {
                return R.drawable.condition_bad_red
            }
            BatteryManager.BATTERY_HEALTH_GOOD -> {
                return R.drawable.condition_good
            }
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> {
                return R.drawable.condition_bad_red
            }
            BatteryManager.BATTERY_HEALTH_DEAD -> {
                return R.drawable.condition_bad_red
            }
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> {
                return R.drawable.condition_bad_red
            }
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> {
                return R.drawable.condition_bad_red
            }
            BatteryManager.BATTERY_HEALTH_COLD -> {
                return R.drawable.condition_bad_blue
            }
            else -> {
                return R.drawable.condition_bad_red
            }
        }
    }

    @JvmStatic
    fun getChargingSummary(context: Context?, data: ChargingEntity?): String {
        var returnString = ""

        // charging
        if (data!!.startTimestamp > data.stopTimestamp && data.startLevel != 0) {
            val time = getHourMinStringFromMillis(System.currentTimeMillis() - data.startTimestamp)
            returnString += context!!.getString(R.string.started_ago, time)

            // not charging
        } else if (data.startTimestamp < data.stopTimestamp) {
            val timeString = ConversionHelpers.getTimestampAsTimeString(data.stopTimestamp)

            // today
            if (DateUtils.isToday(data.stopTimestamp)) {
                returnString += context?.getString(R.string.stopped_today, timeString)

                // yesterday
            } else if (DateUtils.isToday((data.stopTimestamp) + 24 * 3600000)) {
                returnString += context?.getString(R.string.stopped_yesterday, timeString)
            }

            // this week
            else if (DateUtils.isToday((data.stopTimestamp) + 24 * 6 * 3600000)) {
                returnString += context?.getString(R.string.stopped_day, ConversionHelpers.getWeekdayString(context, data.stopTimestamp), timeString)
            }
            // otherwise date
            else {
                val flags = DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_NO_YEAR
                returnString += DateUtils.formatDateTime(context, data.stopTimestamp, flags) + " "
            }


            // Charged ..min from ..% to ..%
            returnString += (context?.getString(R.string.szCharged) + " "
                    + getHourMinStringFromMillis(data.stopTimestamp - data.startTimestamp) + " - "
                    + context?.getString(R.string.szFrom) + " " + data.startLevel + "% "
                    + context?.getString(R.string.szTo) + " " + data.stopLevel + "%")

            val minutes: Long = getMinutesFromMillis(data.stopTimestamp - data.startTimestamp)
            if (minutes > 0 && (data.stopLevel - data.startLevel) > 0) { // TODO 5 to 0 temporary
                val averagePerHour = (data.stopLevel - data.startLevel).toFloat() / (minutes.toFloat() / 60.0f)
                returnString += ("\n" + context?.getString(R.string.avg) + " " + averagePerHour.toInt() + "%/h")
            }
/*
             if (data.lLastChargingFull > 0 && data.lLastChargingStop < 95) {
                 str = str + ("\n " + context?.getString(R.string.szFull) + " >=95%: " + LocalLibrary.getTimestampAsDateString(data.lLastChargingFull))
             }
*/
        }
        return returnString
    }

    private fun getHourMinStringFromMillis(diff: Long): String {
        var min = diff / 1000 / 60
        if (min > 60) {
            val hour = min.toInt() / 60
            val leftMin = min.toInt() % 60
            return hour.toString() + "h " + leftMin + "min"
        }
        if (min == 0L) min = 1
        return min.toString() + "min"
    }

    private fun getMinutesFromMillis(diff: Long): Long {
        return diff / 1000 / 60
    }

    @JvmStatic
    fun calculateChargingSpeed(data: ChargingEntity): Float {

        return 0.0f
    }

}