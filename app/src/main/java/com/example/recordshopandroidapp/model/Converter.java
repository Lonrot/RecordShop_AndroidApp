// File: Converter.java
package com.example.recordshopandroidapp.model;

import android.util.Log;
import androidx.databinding.BindingConversion;
import androidx.databinding.InverseMethod;

public class Converter {

    private static final String TAG = "Converter";

    @BindingConversion
    public static String fromInt(int value) {
        return String.valueOf(value);
    }

    @BindingConversion
    @InverseMethod("fromInt")
    public static int toInt(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Integer.parseInt(value);

        } catch (NumberFormatException e) {

            Log.e(TAG, "Error parsing integer from string: " + value, e);
            return 0;
        }
    }

    @BindingConversion
    public static String fromDouble(double value) {
        return String.valueOf(value);
    }
    @BindingConversion
    @InverseMethod("fromDouble")
    public static double toDouble(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Double.parseDouble(value);

        } catch (NumberFormatException e) {

            Log.e(TAG, "Error parsing integer from string: " + value, e);
            return 0;
        }

    }
}
