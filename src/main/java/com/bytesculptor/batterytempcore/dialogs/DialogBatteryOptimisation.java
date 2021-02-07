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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bytesculptor.batterytempcore.R;


public class DialogBatteryOptimisation extends DialogFragment {

    boolean isSettingsMenu;

    public interface DialogOptimisationStartupListener {
        void onClickOptimisation();
    }

    public DialogOptimisationStartupListener mListener;

    public DialogBatteryOptimisation(boolean isSettingsMenu) {
        this.isSettingsMenu = isSettingsMenu;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (DialogOptimisationStartupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl DialogOptimisationStartupListener interface in host activity");
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setCancelable(false);
        builder.setTitle(getString(R.string.pref_optim_title));
        String text = getString(R.string.szAskForBatOptimisation1);
        if (!isSettingsMenu) {
            text += getString(R.string.szAskForBatOptimisation2);
        }
        builder.setMessage(text);
        builder.setPositiveButton(getString(R.string.szOk), (dialog, id) -> mListener.onClickOptimisation());
        builder.setNegativeButton(getString(R.string.szCancel), (dialog, id) -> dismiss());
        builder.create();
        return builder.create();
    }
}