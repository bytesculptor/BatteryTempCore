package com.bytesculptor.batterytempcore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bytesculptor.batterytempcore.utilities.Constants

@Entity(tableName = Constants.TABLE_NAME_HEALTH)
class HealthEventEntity {

    constructor(id: Int, timestamp: Int, healthEventType: Int, healthEventValue: Int) {
        this.id = id
        this.timestamp = timestamp
        this.healthEventType = healthEventType
        this.healthEventValue = healthEventValue
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants._ID)
    var id = 0

    @ColumnInfo(name = Constants.TIMESTAMP)
    var timestamp: Int = 0

    @ColumnInfo(name = Constants.HEALTH_EVENT_TYPE)
    var healthEventType = 0

    @ColumnInfo(name = Constants.HEALTH_EVENT_VALUE)
    var healthEventValue = 0
}