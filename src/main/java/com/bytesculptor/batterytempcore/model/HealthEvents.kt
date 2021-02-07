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

enum class HealthEvents(i: Int) {
    OVERHEAT(1), COLD(2), OVER_VOLTAGE(3), UNSPECIFIED(4), DEAD(5);

    var id = 0

    init {
        id = i
    }
}