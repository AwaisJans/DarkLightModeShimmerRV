package com.jans.rv.shimmer.dark.mode.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.jans.rv.shimmer.dark.mode.app.appUtils.DarkModePreference
import com.jans.rv.shimmer.dark.mode.app.R

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar!!.hide()

        val prefDarkMode = DarkModePreference(this)
        val isDarkMode = prefDarkMode.isDarkModeEnabled()

        if (isDarkMode) {
            // Enable dark mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Disable dark mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        Handler().postDelayed({
            startActivity(Intent(this,FirstScreen::class.java))
            finish()
        },1000)



    }


}