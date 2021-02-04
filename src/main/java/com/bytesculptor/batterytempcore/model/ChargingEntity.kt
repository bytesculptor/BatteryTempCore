package com.bytesculptor.batterytempcore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bytesculptor.batterytempcore.utilities.Constants

@Entity(tableName = Constants.TABLE_NAME_CHARGING)
class ChargingEntity {

    constructor(id: Int, startTimestamp: Int, startLevel: Int, stopTimestamp: Int, stopLevel: Int, healthEvent: Int, chargeSpeed: Double) {
        this.id = id
        this.startTimestamp = startTimestamp
        this.startLevel = startLevel
        this.stopTimestamp = stopTimestamp
        this.stopLevel = stopLevel
        this.healthEvent = healthEvent
        this.chargeSpeed = chargeSpeed
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants._ID)
    var id = 0

    @ColumnInfo(name = Constants.START_TIMESTAMP)
    var startTimestamp: Int = 0

    @ColumnInfo(name = Constants.START_LEVEL)
    var startLevel = 0

    @ColumnInfo(name = Constants.STOP_TIMESTAMP)
    var stopTimestamp: Int = 0

    @ColumnInfo(name = Constants.STOP_LEVEL)
    var stopLevel = 0

    @ColumnInfo(name = Constants.HEALTH_EVENT_TYPE)
    var healthEvent = 0

    @ColumnInfo(name = Constants.CHARGE_SPEED)
    var chargeSpeed = 0.0
}