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
package com.bytesculptor.batterytempcore.help

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bytesculptor.applib.utilities.ExternalLinksHelper
import com.bytesculptor.batterytempcore.R

class DisclaimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_disclaimer)
        val feedback = findViewById<TextView>(com.bytesculptor.applib.R.id.tvFeedbackMailLink)
        feedback?.setOnClickListener { v: View? -> ExternalLinksHelper.sendFeedbackMail(this, "") }   // TODO get app name
    }
}