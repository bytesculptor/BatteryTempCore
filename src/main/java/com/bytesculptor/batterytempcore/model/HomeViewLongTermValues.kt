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

class HomeViewLongTermValues(
        var iMinLevel: Int,
        var iMaxLevel: Int,
        var lMinLevelDate: Long,
        var lMaxLevelDate: Long,
        var iMinTemp: Int,
        var iMaxTemp: Int,
        var lMinTempDate: Long,
        var lMaxTempDate: Long,
        var iMinVolt: Int,
        var iMaxVolt: Int,
        var lMinVoltDate: Long,
        var lMaxVoltDate: Long)