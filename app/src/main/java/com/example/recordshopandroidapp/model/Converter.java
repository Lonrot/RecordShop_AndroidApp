package com.example.recordshopandroidapp.model;

import android.util.Log;
import androidx.databinding.InverseMethod;

public class Converter {

    private static final String TAG = "Converter";

    @InverseMethod("toInt")
    public static String fromInt(int value) {
        return String.valueOf(value);
    }

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
}