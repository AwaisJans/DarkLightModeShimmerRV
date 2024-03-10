package com.jans.rv.shimmer.dark.mode.app.appUtils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.widget.ImageView

class ConfigApp {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context?=null

        // Default Assigned Colors incase of empty values
        const val defaultModule1TintColor = "#1a1a1a"
        const val defaultModule2TintColor = "#801818"
        const val defaultModule3TintColor = "#556b2f"
        const val defaultModule4TintColor = "#f0a858"


        // function that assign theme according to theme
        fun assignColorWithDarkLightMode(imgSample:ImageView,moduleName:String) {
            val context = imgSample.context
            val activity = context as Activity

            val prefDarkMode = DarkModePreference(context)
            val isDarkMode = prefDarkMode.isDarkModeEnabled()

            val colorPrimaryDark = activity.intent.getStringExtra("DarkColor")!!
            val colorPrimaryLight = activity.intent.getStringExtra("LightColor")!!

            var defaultTint = ""

            when(moduleName){
                "Module1" ->{
                    defaultTint = defaultModule1TintColor
                }
                "Module2" ->{
                    defaultTint = defaultModule2TintColor
                }
                "Module3" ->{
                    defaultTint = defaultModule3TintColor
                }
                "Module4" ->{
                    defaultTint = defaultModule4TintColor
                }
            }

            if (isDarkMode) {
                // dark mode Color
                if (colorPrimaryDark.isEmpty()) {
                    imgSample.setColorFilter(Color.parseColor(defaultTint))
                } else {
                    imgSample.setColorFilter(Color.parseColor(colorPrimaryDark))
                }
            } else {
                // Disable dark mode
                if (colorPrimaryLight.isEmpty()) {
                    imgSample.setColorFilter(Color.parseColor(defaultTint))
                } else {
                    imgSample.setColorFilter(Color.parseColor(colorPrimaryLight))
                }
            }
        }


    }
}