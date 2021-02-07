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

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.bytesculptor.batterytempcore.R;
import com.bytesculptor.batterytempcore.utilities.LocalLibrary;

import static com.bytesculptor.batterytempcore.utilities.Constants.DEFAULT_HIGH_TEMP_WARNING_CELSIUS;
import static com.bytesculptor.batterytempcore.utilities.Constants.DEFAULT_HIGH_TEMP_WARNING_FAHRENHEIT;
import static com.bytesculptor.batterytempcore.utilities.Constants.HIGH_TEMP_WARNING_CELSIUS_MAX;
import static com.bytesculptor.batterytempcore.utilities.Constants.HIGH_TEMP_WARNING_CELSIUS_MIN;
import static com.bytesculptor.batterytempcore.utilities.Constants.HIGH_TEMP_WARNING_FAHRENHEIT_MAX;
import static com.bytesculptor.batterytempcore.utilities.Constants.HIGH_TEMP_WARNING_FAHRENHEIT_MIN;
import static com.bytesculptor.batterytempcore.utilities.Constants.KEY_PREF_FAHRENHEIT_SWITCH;
import static com.bytesculptor.batterytempcore.utilities.Constants.PREF_tempNotificationHighCelsius;
import static com.bytesculptor.batterytempcore.utilities.Constants.PREF_tempNotificationHighFahrenheit;


public class TemperatureHighDialog extends DialogFragment {
    String TAG = TemperatureHighDialog.class.getSimpleName();

    public interface TemperatureDialogListener {
        void onHighTempLimitChanged(int newValue);
    }

    public TemperatureHighDialog.TemperatureDialogListener mListener;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (TemperatureHighDialog.TemperatureDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must impl TemperatureDialogListener interface in host activity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_number_picker, container, false);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(requireContext());
        boolean bFahrenheit = settings.getBoolean(KEY_PREF_FAHRENHEIT_SWITCH, false);

        TextView header = view.findViewById(R.id.tvHeaderTemp);
        TextView unit = view.findViewById(R.id.tvDegreeUnit);
        String temperatureUnit = bFahrenheit ? "°F" : "°C";
        header.setText(R.string.pref_title_max_temp_notification);
        unit.setText(temperatureUnit);
        NumberPicker numberPicker = view.findViewById(R.id.number_picker);

        if (bFahrenheit) {
            numberPicker.setMinValue(HIGH_TEMP_WARNING_FAHRENHEIT_MIN);
            numberPicker.setMaxValue(HIGH_TEMP_WARNING_FAHRENHEIT_MAX);
            int maxLimit = settings.getInt(PREF_tempNotificationHighFahrenheit, DEFAULT_HIGH_TEMP_WARNING_FAHRENHEIT);
            numberPicker.setValue(maxLimit);
        } else {
            numberPicker.setMinValue(HIGH_TEMP_WARNING_CELSIUS_MIN);
            numberPicker.setMaxValue(HIGH_TEMP_WARNING_CELSIUS_MAX);
            int maxLimit = settings.getInt(PREF_tempNotificationHighCelsius, DEFAULT_HIGH_TEMP_WARNING_CELSIUS);
            numberPicker.setValue(maxLimit);
        }

        //numberPicker.setFadingEdgeEnabled(true);
        //numberPicker.setScrollerEnabled(true);
        numberPicker.setWrapSelectorWheel(false);
        //numberPicker.setAccessibilityDescriptionEnabled(true);

        Button btSave = view.findViewById(R.id.btOkTemp);
        btSave.setOnClickListener(save -> {
            SharedPreferences.Editor editor = settings.edit();
            int returnValue = numberPicker.getValue();
            if (bFahrenheit) {
                editor.putInt(PREF_tempNotificationHighFahrenheit, returnValue);
                editor.putInt(PREF_tempNotificationHighCelsius, (int) LocalLibrary.convertToCelsius(returnValue));
            } else {
                editor.putInt(PREF_tempNotificationHighFahrenheit, (int) LocalLibrary.convertToFahrenheit(returnValue));
                editor.putInt(PREF_tempNotificationHighCelsius, returnValue);
            }
            editor.apply();
            mListener.onHighTempLimitChanged(returnValue);
            dismiss();
        });

        Button btCancel = view.findViewById(R.id.btCancel);
        btCancel.setOnClickListener(v1 -> dismiss());

        return view;
    }
}