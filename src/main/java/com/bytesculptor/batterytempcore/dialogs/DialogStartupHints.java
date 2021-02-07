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

import static com.bytesculptor.batterytempcore.utilities.Constants.HINT_KEY_FIRST_START;

/**
 * Created by ro on 25.08.17.
 */
public class DialogStartupHints extends DialogFragment {

    public interface StartupHintsDialogListener {
        void onStartupHintAgreed(int key);
    }

    public StartupHintsDialogListener mListener;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (StartupHintsDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl StartupHintsDialogListener interface in host activity");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String helpText = args.getString("help", "!missing text!");
        final int key = args.getInt("key", -1);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        if (key == HINT_KEY_FIRST_START) {
            builder.setMessage(helpText).setTitle(getString(R.string.szWelcome));
        } else {
            builder.setMessage(helpText).setTitle(getString(R.string.szHint));
        }

        builder.setPositiveButton("OK", (dialog, id) -> mListener.onStartupHintAgreed(key));

        return builder.create();
    }
}