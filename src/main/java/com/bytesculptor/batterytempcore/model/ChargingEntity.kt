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

package com.bytesculptor.batterytempcore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.bytesculptor.batterytempcore.utilities.Constants
import com.bytesculptor.batterytempcore.utilities.Constants.*

@Entity(tableName = TABLE_NAME_CHARGING)
class ChargingEntity {

    constructor(id: Int, startTimestamp: Long, startLevel: Int, stopTimestamp: Long, stopLevel: Int, chargeAmount: Int, chargerType: Int, chargeSpeed: Int) {
        this.id = id
        this.startTimestamp = startTimestamp
        this.startLevel = startLevel
        this.stopTimestamp = stopTimestamp
        this.stopLevel = stopLevel
        this.chargeAmount = chargeAmount
        this.chargerType = chargerType
        this.chargeSpeed = chargeSpeed
    }

    @Ignore
    constructor(startTimestamp: Long, startLevel: Int, stopTimestamp: Long, stopLevel: Int, chargeAmount: Int, chargerType: Int, chargeSpeed: Int) {
        this.startTimestamp = startTimestamp
        this.startLevel = startLevel
        this.stopTimestamp = stopTimestamp
        this.stopLevel = stopLevel
        this.chargeAmount = chargeAmount
        this.chargerType = chargerType
        this.chargeSpeed = chargeSpeed
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants._ID)
    var id = 0

    @ColumnInfo(name = START_TIMESTAMP)
    var startTimestamp: Long = 0L

    @ColumnInfo(name = START_LEVEL)
    var startLevel = 0

    @ColumnInfo(name = STOP_TIMESTAMP)
    var stopTimestamp: Long = 0L

    @ColumnInfo(name = STOP_LEVEL)
    var stopLevel = 0

    @ColumnInfo(name = CHARGE_AMOUNT)
    var chargeAmount = 0

    @ColumnInfo(name = CHARGER_TYPE)
    var chargerType = 0

    @ColumnInfo(name = CHARGE_SPEED)
    var chargeSpeed = 0
}