package com.bytesculptor.batterytempcore.model

enum class HealthEvents(i: Int) {
    OVERHEAT(1), COLD(2), OVER_VOLTAGE(3), UNSPECIFIED(4), DEAD(5);

    var id = 0

    init {
        id = i
    }
}