package com.example.androidlocalization.manager

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

internal var sharedPreferences: SharedPreferences? = null

class PrefsManager private constructor(private val context: Context) {


    companion object {
        @SuppressLint("StaticFieldLeak")
        private var prefsManager: PrefsManager? = null

        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    }

    fun saveData(key: String?, value: String) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun getData(key: String?): String? {
        return if (sharedPreferences != null) sharedPreferences?.getString(key, "") else "en"
    }

    fun removeData(key: String?) {
        val prefs: SharedPreferences =
            context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove(key)
        editor.apply()
    }

    fun clear() {
        val prefs: SharedPreferences =
            context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}