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

package com.bytesculptor.batterytempcore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.bytesculptor.batterytempcore.utilities.Constants

@Entity(tableName = Constants.TABLE_NAME_LOG)
class LogEntity {

    @Ignore
    constructor(timestamp: Long, level: Int, temp: Int, volt: Int, dateTime: String) {
        this.timestamp = timestamp
        this.level = level
        this.temp = temp
        this.volt = volt
        this.dateTime = dateTime
    }

    constructor(id: Int, timestamp: Long, level: Int, temp: Int, volt: Int, dateTime: String) {
        this.id = id
        this.timestamp = timestamp
        this.level = level
        this.temp = temp
        this.volt = volt
        this.dateTime = dateTime
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants._ID)
    var id = 0

    @ColumnInfo(name = Constants.TIMESTAMP)
    var timestamp: Long = 0

    @ColumnInfo(name = Constants.LEVEL)
    var level = 0

    @ColumnInfo(name = Constants.TEMP)
    var temp = 0

    @ColumnInfo(name = Constants.VOLT)
    var volt = 0

    @ColumnInfo(name = Constants.DATETIME)
    var dateTime: String = ""


}