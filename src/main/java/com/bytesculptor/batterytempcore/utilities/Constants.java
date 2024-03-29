/*
 * Copyright (c)  2021 Byte Sculptor Software - All Rights Reserved
 *
 * All information contained herein is and remains the property of Byte Sculptor Software.
 * Unauthorized copying of this file, via any medium, is strictly prohibited unless prior
 * written permission is obtained from Byte Sculptor Software.
 *
 * Romeo Rondinelli - bytesculptor@gmail.com
 *
 */

package com.bytesculptor.batterytempcore.utilities;

public class Constants {

    public static final String KEY_PREF_NOTIFY = "notify_switch";
    public static final String KEY_PREF_TEMP_UNIT = "KEY_PREF_TEMP_UNIT";
    public static final String KEY_PREF_LOG_DURATION = "KEY_PREF_LOG_DURATION";
    public static final String KEY_PREF_HIDE_VOLTAGE = "KEY_PREF_HIDE_VOLTAGE";
    public static final String KEY_PREF_DAY_LINES = "day_line_switch";
    public static final String KEY_PREF_NOTIF_SETTINGS_WARNING = "KEY_PREF_NOTIF_SETTINGS_WARNING";
    public static final String KEY_PREF_NOTIF_SETTINGS_CURRENT = "KEY_PREF_NOTIF_SETTINGS_CURRENT";
    public static final String KEY_PREF_NOTIF_TEMP_LOW = "KEY_PREF_NOTIF_TEMP_LOW";
    public static final String KEY_PREF_NOTIF_TEMP_HIGH = "KEY_PREF_NOTIF_TEMP_HIGH";
    public static final String KEY_PREF_SHOW_TEMP_ON_WARNING = "KEY_PREF_SHOW_TEMP_ON_WARNING";

    public static final long MILLIS_PER_HOUR = 3600 * 1000;
    public static final float TEXT_SIZE_GRAPH_AXIS = 11.0f;
    public static final int GRAPH_ANIMATION_TIME_IN_MS = 1200;

    public static final int BATTERY_EVENT_NOTIFY_HIGH_LIMIT = 2000;
    public static final int BATTERY_EVENT_NOTIFY_LOW_LIMIT = 2001;


    // temperature warning
    public static final int LOW_TEMP_WARNING_CELSIUS_MIN = 0;
    public static final int LOW_TEMP_WARNING_CELSIUS_MAX = 20;
    public static final int HIGH_TEMP_WARNING_CELSIUS_MIN = 30;
    public static final int HIGH_TEMP_WARNING_CELSIUS_MAX = 50;
    public static final int LOW_TEMP_WARNING_FAHRENHEIT_MIN = 32;
    public static final int LOW_TEMP_WARNING_FAHRENHEIT_MAX = 68;
    public static final int HIGH_TEMP_WARNING_FAHRENHEIT_MIN = 86;
    public static final int HIGH_TEMP_WARNING_FAHRENHEIT_MAX = 122;
    public static final int DEFAULT_LOW_TEMP_WARNING_CELSIUS = 15;
    public static final int DEFAULT_HIGH_TEMP_WARNING_CELSIUS = 36;
    public static final int DEFAULT_LOW_TEMP_WARNING_FAHRENHEIT = 60;
    public static final int DEFAULT_HIGH_TEMP_WARNING_FAHRENHEIT = 95;

    public static final int LOWER_LIMIT_TEMP_GOOD = 120;    // deka degree!
    public static final int UPPER_LIMIT_TEMP_GOOD = 370;    // deka degree!
    public static final int LOWER_LIMIT_TEMP_WARNING = 80;  // deka degree!
    public static final int UPPER_LIMIT_TEMP_WARNING = 420; // deka degree!

    public static final int LOWER_LIMIT_LEVEL_GOOD = 35;
    public static final int LOWER_LIMIT_LEVEL_WARNING = 20;

    public static final String PREF_tempNotificationLowCelsius = "tempNotificationLowCelsius";
    public static final String PREF_tempNotificationHighCelsius = "tempNotificationHighCelsius";
    public static final String PREF_tempNotificationLowFahrenheit = "tempNotificationLowFahrenheit";
    public static final String PREF_tempNotificationHighFahrenheit = "tempNotificationHighFahrenheit";

    // settings
    public static final int ITEM_LEVEL = 1;
    public static final int ITEM_TEMP = 2;
    public static final int ITEM_VOLT = 3;

    public static final int THEME_LIGHT = 0;
    public static final int THEME_DARK = 1;
    public static final int THEME_SYSTEM = 2;

    public static final int UNIT_CELSIUS = 0;
    public static final int UNIT_FAHRENHEIT = 1;

    public static final String KEY_PREF_DARK_MODE = "KEY_PREF_DARK_MODE";


    // logging
    public static final String LOG_minTemp = "minTemp";
    public static final String LOG_maxTemp = "maxTemp";
    public static final String LOG_minTempDate = "minTempDate";
    public static final String LOG_maxTempDate = "maxTempDate";

    public static final String LOG_minVolt = "minVolt";
    public static final String LOG_maxVolt = "maxVolt";
    public static final String LOG_minVoltDate = "minVoltDate";
    public static final String LOG_maxVoltDate = "maxVoltDate";

    public static final String LOG_minLevel = "minLevel";
    public static final String LOG_maxLevel = "maxLevel";
    public static final String LOG_minLevelDate = "minLevelDate";
    public static final String LOG_maxLevelDate = "maxLevelDate";

    public static final String LOG_lastChargingStarted = "lastChargingStarted";
    public static final String LOG_lastChargingStopped = "lastChargingStopped";
    public static final String LOG_lastChargingFullTimestamp = "lastChargingFullTimestamp";
    public static final String LOG_batStartLevel = "batStartLevel";
    public static final String LOG_batStopLevel = "batStopLevel";

    public static final String PREF_historyButtonGroup = "historyButtonGroup";
    public static final String PREF_HINT_firstTimeHist = "firstTimeHist";

    public static final int HINT_KEY_FIRST_START = 1;
    public static final int HINT_KEY_HIST = 2;

    public static final String PREF_showDotsTemp = "showDotsTemp";
    public static final String PREF_showValuesTemp = "showValuesTemp";
    public static final String PREF_showLevelTemp = "showLevelTemp";

    public static final String PREF_showDotsVolt = "showDotsVolt";
    public static final String PREF_showValuesVolt = "showValuesVolt";
    public static final String PREF_showLevelVolt = "showLevelVolt";

    // names for tables and columns
    public static final String TABLE_NAME_LOG = "BatteryLogTable";
    public static final String _ID = "_id";
    public static final String TIMESTAMP = "timestamp";
    public static final String LEVEL = "level";
    public static final String TEMP = "temperature";
    public static final String VOLT = "voltage";
    public static final String DATETIME = "dateTime";

    public static final String TABLE_NAME_CHARGING = "ChargingLogTable";
    public static final String START_TIMESTAMP = "startTimestamp";
    public static final String STOP_TIMESTAMP = "stopTimestamp";
    public static final String START_LEVEL = "startLevel";
    public static final String STOP_LEVEL = "stopLevel";
    public static final String CHARGE_SPEED = "chargeSpeed";
    public static final String CHARGE_AMOUNT = "chargeAmount";
    public static final String CHARGER_TYPE = "chargerType";

}
