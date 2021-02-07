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

package com.bytesculptor.batterytempcore.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bytesculptor.batterytempcore.R;

public class DialogOptimization extends DialogFragment {

    public interface DialogOptimizationListener {
        void onClickOptimization();
    }

    public DialogOptimizationListener mListener;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (DialogOptimizationListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl DialogOptimizationListener interface in host activity");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setMessage(R.string.msg_optimize);
        builder.setPositiveButton("OK", (dialog, id) -> mListener.onClickOptimization());
        builder.create();
        return builder.create();
    }
}