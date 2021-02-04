package com.bytesculptor.batterytempcore.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bytesculptor.batterytempcore.R;

import org.jetbrains.annotations.NotNull;

import static com.bytesculptor.batterytempcore.utilities.Constants.ITEM_LEVEL;
import static com.bytesculptor.batterytempcore.utilities.Constants.ITEM_TEMP;
import static com.bytesculptor.batterytempcore.utilities.Constants.ITEM_VOLT;

public class DialogResetLongTerm extends DialogFragment {

    public interface ResetDialogListener {
        void onResetAgree(int item);
    }

    public ResetDialogListener mListener;

    public void onAttach(@NotNull Context context) {
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
            case ITEM_LEVEL:
                builder.setTitle(R.string.reset_level);
                break;

            case ITEM_TEMP:
                builder.setTitle(R.string.reset_temperature);
                break;

            case ITEM_VOLT:
                builder.setTitle(R.string.reset_volt);
                break;
        }

        builder.setMessage(R.string.reset_msg);
        builder.setPositiveButton(getString(R.string.szYes), (dialog, id) -> mListener.onResetAgree(resetItem));
        builder.setNegativeButton(getString(R.string.szCancel), null);

        return builder.create();
    }
}
