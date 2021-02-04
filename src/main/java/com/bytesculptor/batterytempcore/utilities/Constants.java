package com.bytesculptor.batterytempcore.utilities;

public class Constants {

    public static final String KEY_PREF_NOTIFY = "notify_switch";
    public static final String KEY_PREF_FAHRENHEIT_SWITCH = "fahrenheit_switch";
    public static final String KEY_PREF_LOG_DURATION = "log_duration";
    public static final String KEY_PREF_HIDE_VOLTAGE = "KEY_PREF_HIDE_VOLTAGE";
    public static final String KEY_PREF_OLD_SCREEN = "KEY_PREF_OLD_SCREEN";
    public static final String KEY_PREF_DAY_LINES = "day_line_switch";
    public static final String KEY_PREF_NOTIF_SETTINGS_WARNING = "KEY_PREF_NOTIF_SETTINGS_WARNING";
    public static final String KEY_PREF_NOTIF_SETTINGS_CURRENT = "KEY_PREF_NOTIF_SETTINGS_CURRENT";
    public static final String KEY_PREF_NOTIF_TEMP_LOW = "KEY_PREF_NOTIF_TEMP_LOW";
    public static final String KEY_PREF_NOTIF_TEMP_HIGH = "KEY_PREF_NOTIF_TEMP_HIGH";

    public static final long MILLIS_PER_HOUR = 3600 * 1000;
    public static final float TEXT_SIZE_GRAPH_AXIS = 11.0f;

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

    public static final String PREF_darkMode = "KEY_PREF_DARK_MODE_2";


    // logging
    public static final String PREF_minTemp = "minTemp";
    public static final String PREF_maxTemp = "maxTemp";
    public static final String PREF_minTempDate = "minTempDate";
    public static final String PREF_maxTempDate = "maxTempDate";

    public static final String PREF_minVolt = "minVolt";
    public static final String PREF_maxVolt = "maxVolt";
    public static final String PREF_minVoltDate = "minVoltDate";
    public static final String PREF_maxVoltDate = "maxVoltDate";

    public static final String PREF_minLevel = "minLevel";
    public static final String PREF_maxLevel = "maxLevel";
    public static final String PREF_minLevelDate = "minLevelDate";
    public static final String PREF_maxLevelDate = "maxLevelDate";

    public static final String PREF_lastChargingStarted = "lastChargingStarted";
    public static final String PREF_lastChargingStopped = "lastChargingStopped";
    public static final String PREF_lastChargingFullTimestamp = "lastChargingFullTimestamp";
    public static final String PREF_batStartLevel = "batStartLevel";
    public static final String PREF_batStopLevel = "batStopLevel";
    public static final String PREF_batChargingCycles = "batChargingCycles";
    public static final String PREF_batChargingCyclesDate = "batChargingCyclesDate";
    public static final String PREF_batTotalChargingPercent = "batTotalChargingPercent";
    public static final String PREF_batTotalChargingPercentDate = "batTotalChargingPercentDate";
    public static final String PREF_batTotalChargingPercentCharges = "batTotalChargingPercentCharges";


    public static final String PREF_notifLowTemp = "notifLowTemp";
    public static final String PREF_notifLowTempDate = "notifLowTempDate";
    public static final String PREF_notifHighTemp = "notifHighTemp";
    public static final String PREF_notifHighTempDate = "notifHighTempDate";

    public static final String PREF_historySlider = "history_slider";

    public static final String PREF_HINT_firstTimeApp = "firstTimeApp";
    public static final String PREF_HINT_firstTimeHist = "firstTimeHist";

    public static final int HINT_KEY_FIRST_START = 1;
    public static final int HINT_KEY_HIST = 2;

    public static final String PREF_showDotsTemp = "showDotsTemp";
    public static final String PREF_showValuesTemp = "showValuesTemp";
    public static final String PREF_showLevelTemp = "showLevelTemp";

    public static final String PREF_showDotsVolt = "showDotsVolt";
    public static final String PREF_showValuesVolt = "showValuesVolt";
    public static final String PREF_showLevelVolt = "showLevelVolt";

    public static final String CHARGING_DATA_PATH = "com.bytesculptor.bamowiplus.charging";

    // database
    public static final String DATABASE_NAME = "batteryLog.db";
    private static final int DATABASE_VERSION = 1;

    // names for tables and columns
    public static final String _ID = "_id";
    public static final String TIMESTAMP = "timestamp";
    public static final String START_TIMESTAMP = "startTimestamp";
    public static final String STOP_TIMESTAMP = "stopTimestamp";

    public static final String TABLE_NAME_LOG = "BatteryLogTable";
    public static final String TABLE_NAME_HEALTH = "HealthLogTable";
    public static final String TABLE_NAME_CHARGING = "ChargingLogTable";

    public static final String LEVEL = "level";
    public static final String START_LEVEL = "startLevel";
    public static final String STOP_LEVEL = "stopLevel";
    public static final String CHARGE_SPEED = "chargeSpeed";
    public static final String TEMP = "temperature";
    public static final String VOLT = "voltage";
    public static final String DATETIME = "dateTime";

    public static final String HEALTH_EVENT_TYPE = "healthEventType";
    public static final String HEALTH_EVENT_VALUE = "healthEventValue";

}
