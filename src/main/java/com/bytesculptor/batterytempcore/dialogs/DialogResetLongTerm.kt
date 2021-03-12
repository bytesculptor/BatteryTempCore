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
package com.bytesculptor.batterytempcore.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bytesculptor.batterytempcore.R
import com.bytesculptor.batterytempcore.utilities.Constants

class DialogResetLongTerm(val dialogInterface: ResetDialogListener) : DialogFragment() {

    interface ResetDialogListener {
        fun onResetAgree(item: Int)
    }

    private var mListener = dialogInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val args = arguments
        val resetItem = args!!.getInt("reset", 0)
        when (resetItem) {
            Constants.ITEM_LEVEL -> builder.setTitle(R.string.reset_level)
            Constants.ITEM_TEMP -> builder.setTitle(R.string.reset_temperature)
            Constants.ITEM_VOLT -> builder.setTitle(R.string.reset_volt)
        }
        builder.setMessage(R.string.reset_msg)
        builder.setPositiveButton(getString(R.string.szYes)) { dialog: DialogInterface?, id: Int -> mListener!!.onResetAgree(resetItem) }
        builder.setNegativeButton(getString(R.string.szCancel), null)
        return builder.create()
    }
}