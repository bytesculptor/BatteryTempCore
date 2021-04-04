/*
 * Copyright (c)  2021 Byte Sculptor Software - All Rights Reserved
 *
 * All information contained herein is and remains the property of Byte Sculptor Software.
 * Unauthorized copying of this file, via any medium, is strictly prohibited unless prior
 * written permission is obtained from Byte Sculptor Software.
 *
 * Romeo Rondinelli - bytesculptor@gmail.com
 *
 */

package com.bytesculptor.batterytempcore.dialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;

import com.bytesculptor.batterytempcore.R;
import com.bytesculptor.batterytempcore.utilities.Constants;
import com.bytesculptor.batterytempcore.utilities.ConversionHelpers;
import com.shawnlin.numberpicker.NumberPicker;

import static com.bytesculptor.batterytempcore.utilities.Constants.KEY_PREF_TEMP_UNIT;
import static com.bytesculptor.batterytempcore.utilities.Constants.UNIT_FAHRENHEIT;

public class TemperatureLowDialog extends DialogFragment {
    String TAG = TemperatureLowDialog.class.getSimpleName();

    public interface TemperatureDialogListener {
        void onLowTempLimitChanged(int newValue);
    }

    public TemperatureLowDialog.TemperatureDialogListener mListener;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (TemperatureLowDialog.TemperatureDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl TemperatureDialogListener interface in host activity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_number_picker, container, false);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(requireContext());
        int tempUnit = Integer.parseInt(settings.getString(KEY_PREF_TEMP_UNIT, "0"));

        TextView header = view.findViewById(R.id.tvHeaderTemp);
        TextView unit = view.findViewById(R.id.tvDegreeUnit);
        String temperatureUnit = tempUnit == UNIT_FAHRENHEIT ? "°F" : "°C";
        header.setText(R.string.pref_title_min_temp_notification);
        unit.setText(temperatureUnit);
        NumberPicker numberPicker = view.findViewById(R.id.number_picker);

        if (tempUnit == UNIT_FAHRENHEIT) {
            numberPicker.setMinValue(Constants.LOW_TEMP_WARNING_FAHRENHEIT_MIN);
            numberPicker.setMaxValue(Constants.LOW_TEMP_WARNING_FAHRENHEIT_MAX);
            int minLimit = settings.getInt(Constants.PREF_tempNotificationLowFahrenheit, Constants.DEFAULT_LOW_TEMP_WARNING_FAHRENHEIT);
            numberPicker.setValue(minLimit);
        } else {
            numberPicker.setMinValue(Constants.LOW_TEMP_WARNING_CELSIUS_MIN);
            numberPicker.setMaxValue(Constants.LOW_TEMP_WARNING_CELSIUS_MAX);
            int minLimit = settings.getInt(Constants.PREF_tempNotificationLowCelsius, Constants.DEFAULT_LOW_TEMP_WARNING_CELSIUS);
            numberPicker.setValue(minLimit);
        }

        numberPicker.setFadingEdgeEnabled(true);
        numberPicker.setScrollerEnabled(true);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setAccessibilityDescriptionEnabled(true);

        Button btSave = view.findViewById(R.id.btOkTemp);
        btSave.setOnClickListener(save -> {
            SharedPreferences.Editor editor = settings.edit();
            int returnValue = numberPicker.getValue();
            if (tempUnit == UNIT_FAHRENHEIT) {
                editor.putInt(Constants.PREF_tempNotificationLowFahrenheit, returnValue);
                editor.putInt(Constants.PREF_tempNotificationLowCelsius, (int) ConversionHelpers.convertToCelsius(returnValue));
            } else {
                editor.putInt(Constants.PREF_tempNotificationLowFahrenheit, (int) ConversionHelpers.convertToFahrenheit(returnValue));
                editor.putInt(Constants.PREF_tempNotificationLowCelsius, returnValue);
            }
            editor.apply();
            mListener.onLowTempLimitChanged(returnValue);
            dismiss();
        });

        Button btCancel = view.findViewById(R.id.btCancel);
        btCancel.setOnClickListener(v1 -> dismiss());

        return view;
    }
}