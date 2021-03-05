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
import com.bytesculptor.batterytempcore.utilities.Constants;

public class DialogResetLongTerm extends DialogFragment {

    public interface ResetDialogListener {
        void onResetAgree(int item);
    }

    public ResetDialogListener mListener;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (ResetDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl ResetDialogListener interface in host activity");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Bundle args = getArguments();
        int resetItem = args.getInt("reset", 0);

        switch (resetItem) {
            case Constants.ITEM_LEVEL:
                builder.setTitle(R.string.reset_level);
                break;

            case Constants.ITEM_TEMP:
                builder.setTitle(R.string.reset_temperature);
                break;

            case Constants.ITEM_VOLT:
                builder.setTitle(R.string.reset_volt);
                break;
        }

        builder.setMessage(R.string.reset_msg);
        builder.setPositiveButton(getString(R.string.szYes), (dialog, id) -> mListener.onResetAgree(resetItem));
        builder.setNegativeButton(getString(R.string.szCancel), null);

        return builder.create();
    }
}