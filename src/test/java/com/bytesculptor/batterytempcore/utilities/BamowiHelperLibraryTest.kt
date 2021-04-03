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

package com.bytesculptor.batterytempcore.utilities

import com.bytesculptor.batterytempcore.model.ChargingEntity
import com.bytesculptor.batterytempcore.utilities.BamowiHelperLibrary.calculateChargingSpeed
import junit.framework.TestCase

class BamowiHelperLibraryTest : TestCase() {

    fun testGetChargingType() {}

    fun testGetHealthText() {}

    fun testGetHealthIcon() {}

    fun testGetChargingSummary() {}

    fun testCalculateChargingSpeed() {
        var testCharge = ChargingEntity(0, 0, 60000, 0, 1, 0, 0)
        assertEquals(60, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 0, 600000, 0, 1, 0, 0)
        assertEquals(6, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 0, 50000, 0, 1, 0, 0)
        assertEquals(72, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 0, 60000, 0, 0, 0, 0)
        assertEquals(0, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 0, 3600000, 0, 32, 0, 0)
        assertEquals(32, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 20, 5 * 60 * 1000, 23, 3, 0, 0)
        assertEquals(36, calculateChargingSpeed(testCharge))

        testCharge = ChargingEntity(0, 20, 295995, 23, 3, 0, 0)
        assertEquals(36, calculateChargingSpeed(testCharge))
    }
}