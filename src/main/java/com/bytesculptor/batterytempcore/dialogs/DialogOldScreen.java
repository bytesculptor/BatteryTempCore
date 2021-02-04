package com.bytesculptor.batterytempcore.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bytesculptor.batterytempcore.R;

public class DialogOldScreen extends DialogFragment {

    public interface OldScreenDialogListener {
        void onScreenChanged();
    }

    public OldScreenDialogListener mListener;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (OldScreenDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl OldScreenDialogListener interface in host activity");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setCancelable(false);
        builder.setTitle(R.string.auto_restart)
                .setMessage(R.string.msg_old_screen);

        builder.setPositiveButton("OK", (dialog, id) -> mListener.onScreenChanged());
        builder.setNegativeButton(R.string.szLater, null);

        return builder.create();
    }
}