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

package com.bytesculptor.batterytempcore.help

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bytesculptor.batterytempcore.R
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class OpenSourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_open_source)
        val more = findViewById<Button>(R.id.btMoreLicenses)
        more.setOnClickListener { startActivity(Intent(applicationContext, OssLicensesMenuActivity::class.java)) }
    }
}