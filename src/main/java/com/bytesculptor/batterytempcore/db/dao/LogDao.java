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

package com.bytesculptor.batterytempcore.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bytesculptor.batterytempcore.model.LevelEntity;
import com.bytesculptor.batterytempcore.model.LogEntity;
import com.bytesculptor.batterytempcore.model.TempEntity;
import com.bytesculptor.batterytempcore.model.VoltEntity;

import java.util.List;

import static com.bytesculptor.batterytempcore.utilities.Constants.LEVEL;
import static com.bytesculptor.batterytempcore.utilities.Constants.TABLE_NAME_LOG;
import static com.bytesculptor.batterytempcore.utilities.Constants.TEMP;
import static com.bytesculptor.batterytempcore.utilities.Constants.TIMESTAMP;
import static com.bytesculptor.batterytempcore.utilities.Constants.VOLT;
import static com.bytesculptor.batterytempcore.utilities.Constants._ID;

@Dao
public interface LogDao {

    @Insert
    void insertLogEntry(LogEntity logs);

    @Query("Select * from " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " >:arg0 ORDER BY " + _ID + " ASC")
    List<LogEntity> queryLogsUntilTimestamp(long timestampInMillis);

    @Query("Select * from " + TABLE_NAME_LOG + " ORDER BY " + _ID + " ASC")
    List<LogEntity> queryLogsUntilTimestamp();

    @Query("Delete FROM " + TABLE_NAME_LOG)
    void deleteAll();

    @Query("Delete FROM " + TABLE_NAME_LOG + " WHERE " + _ID + " =:arg0")
    void deleteById(int id);

    @Query("Delete FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " < :arg0")
    void clearOldEntries(String limit);

    @Query("Select " + TIMESTAMP + ", " + LEVEL + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + LEVEL + " ASC LIMIT 1")
    LevelEntity getMinLevel(long timestamp);

    @Query("Select " + TIMESTAMP + ", " + LEVEL + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + LEVEL + " DESC LIMIT 1")
    LevelEntity getMaxLevel(long timestamp);

    @Query("Select " + TIMESTAMP + ", " + TEMP + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + TEMP + " ASC LIMIT 1")
    TempEntity getMinTemp(long timestamp);

    @Query("Select " + TIMESTAMP + ", " + TEMP + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + TEMP + " DESC LIMIT 1")
    TempEntity getMaxTemp(long timestamp);

    @Query("Select " + TIMESTAMP + ", " + VOLT + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + VOLT + " ASC LIMIT 1")
    VoltEntity getMinVolt(long timestamp);

    @Query("Select " + TIMESTAMP + ", " + VOLT + " FROM " + TABLE_NAME_LOG + " WHERE " + TIMESTAMP + " > :arg0 ORDER BY " + VOLT + " DESC LIMIT 1")
    VoltEntity getMaxVolt(long timestamp);
}
