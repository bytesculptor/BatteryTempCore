/*
 * Copyright (c) 2021  Byte Sculptor Software  - All Rights Reserved
 *
 * All information contained herein is and remains the property of Byte Sculptor Software.
 * Unauthorized copying of this file, via any medium, is strictly prohibited unless prior
 * written permission is obtained from Byte Sculptor Software.
 *
 * Romeo Rondinelli - bytesculptor@gmail.com
 *
 */

package com.bytesculptor.batterytempcore.model

class ChargingSummary(var lLastChargingStart: Long,
                      var lLastChargingStop: Long,
                      var lBatStartLevel: Long,
                      var lBatStopLevel: Long)