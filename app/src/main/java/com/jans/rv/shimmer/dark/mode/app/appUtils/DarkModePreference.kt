package com.jans.rv.shimmer.dark.mode.app.appUtils

import android.content.Context
import android.content.SharedPreferences

class DarkModePreference(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("DarkModePref", Context.MODE_PRIVATE)

    fun isDarkModeEnabled(): Boolean {
        return sharedPreferences.getBoolean("isDarkModeEnabled", false)
    }

    fun setDarkModeEnabled(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean("isDarkModeEnabled", isEnabled).apply()
    }
}