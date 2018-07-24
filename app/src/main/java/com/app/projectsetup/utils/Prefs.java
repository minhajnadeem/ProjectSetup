package com.app.projectsetup.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by minhaj nadeem on 22/07/2018.
 */
public class Prefs {

    private static SharedPreferences prefs = null;
    private static SharedPreferences.Editor editor = null;

    public Prefs(Context context) {
        prefs = context.getSharedPreferences("PREFS_App", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public Boolean getBool(String key, Boolean defaultvalue) {
        if (prefs == null) {
            return false;
        }
        return prefs.getBoolean(key, defaultvalue);
    }

    public void setBool(String key, Boolean value) {
        if (editor == null) {
            return;
        }
        editor.putBoolean(key, value);
        save();
    }

    public int getInt(String key, int defaultvalue) {
        if (prefs == null) {
            return 0;
        }
        return prefs.getInt(key, defaultvalue);
    }

    public void setInt(String key, int value) {
        if (editor == null) {
            return;
        }
        editor.putInt(key, value);
        save();
    }

    public String getValue(String key, String defaultvalue) {
        if (prefs == null) {
            return "Unknown";
        }
        return prefs.getString(key, defaultvalue);
    }

    public void setValue(String key, String value) {
        if (editor == null) {
            return;
        }
        editor.putString(key, value);
        save();
    }

    public void setDouble(String key , Double value){
        if (editor == null) {
            return;
        }
        editor.putString(key, String.valueOf(value));
        save();
    }

    public Double getDouble(String key , Double def_value){
        if (prefs == null) {
            return 0.0;
        }
        return Double.valueOf(prefs.getString(key, String.valueOf(def_value)));
    }

    public void save() {
        if (editor == null) {
            return;
        }
        editor.commit();
    }

    public void clear() {
        if (editor == null) {
            return;
        }
        editor.clear();
        editor.commit();
    }
}
