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
import com.bytesculptor.batterytempcore.model.ChargingSummary
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
    fun getHealthIcon(context: Context?, health: Int): String {
        var returnString = ""
        when (health) {
            BatteryManager.BATTERY_HEALTH_UNKNOWN -> {
                // ivHealth!!.setImageResource(R.drawable.bad)
            }
            BatteryManager.BATTERY_HEALTH_GOOD -> {
                //  ivHealth!!.setImageResource(R.drawable.good)
            }
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> {
                //  ivHealth!!.setImageResource(R.drawable.bad)
            }
            BatteryManager.BATTERY_HEALTH_DEAD -> {
                //   ivHealth!!.setImageResource(R.drawable.bad)
            }
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> {
                //  ivHealth!!.setImageResource(R.drawable.bad)
            }
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> {
                //ivHealth!!.setImageResource(R.drawable.bad)
            }
            BatteryManager.BATTERY_HEALTH_COLD -> {
                //  ivHealth!!.setImageResource(R.drawable.bad)
            }
            else -> {
                //  ivHealth!!.setImageResource(R.drawable.bad)
            }
        }
        return returnString
    }

    @JvmStatic
    fun getChargingSummary(context: Context?, data: ChargingSummary?): String {
        var returnString = ""

        // charging
        if (data!!.lLastChargingStart > data.lLastChargingStop && data.lLastChargingStart != 0L) {
            returnString = context?.getString(R.string.started) + " " + LocalLibrary.getTimestampAsTimeString(data.lLastChargingStart)

            // not charging
        } else if (data.lLastChargingStart < data.lLastChargingStop) {
            returnString = context?.getString(R.string.stopped) + " "
            if (DateUtils.isToday(data.lLastChargingStop)) {
                returnString += "today "
            } else if (DateUtils.isToday((data.lLastChargingStop) + 24 * 3600000)) {
                returnString += "Yesterday "
            } else {
                returnString += LocalLibrary.getTimestampAsDateString(data.lLastChargingStop)
            }
            returnString += LocalLibrary.getTimestampAsTimeString(data.lLastChargingStop)

            // Charged ..min from .. to ..
            returnString += (context?.getString(R.string.szCharged) + " "
                    + getHourMinStringFromMillis(data.lLastChargingStop - data.lLastChargingStart) + " "
                    + context?.getString(R.string.szFrom) + " "
                    + data.lBatStartLevel + "% " + context?.getString(R.string.szTo) + " "
                    + data.lBatStopLevel + "%")

            val minutes: Long = getMinutesFromMillis(data.lLastChargingStop - data.lLastChargingStart)
            if (minutes > 0 && (data.lBatStopLevel - data.lBatStartLevel) > 0) { // TODO 5 to 0 temporary
                val averagePerHour = (data.lBatStopLevel - data.lBatStartLevel).toFloat() / (minutes.toFloat() / 60.0f)
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
        val min = diff / 1000 / 60
        if (min > 60) {
            val hour = min.toInt() / 60
            val leftMin = min.toInt() % 60
            return hour.toString() + "h " + leftMin + "min"
        }
        return min.toString() + "min"
    }

    private fun getMinutesFromMillis(diff: Long): Long {
        return diff / 1000 / 60
    }

}