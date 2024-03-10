package com.jans.rv.shimmer.dark.mode.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.jans.rv.shimmer.dark.mode.app.appUtils.DarkModePreference
import com.jans.rv.shimmer.dark.mode.app.R

class SettingScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)

        title = "App Setting"

        val switchDarkMode = findViewById<SwitchCompat>(R.id.switchDarkMode)

        val prefDarkMode = DarkModePreference(this)
        val isDarkMode = prefDarkMode.isDarkModeEnabled()

        switchDarkMode.isChecked = isDarkMode

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
               prefDarkMode.setDarkModeEnabled(true)
                showToast( "Dark Mode Enabled")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                showToast("Dark Mode Disabled")
                prefDarkMode.setDarkModeEnabled(false)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }

    private fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}