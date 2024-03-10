package com.jans.rv.shimmer.dark.mode.app.activities

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.google.gson.Gson
import com.jans.rv.shimmer.dark.mode.app.R
import com.jans.rv.shimmer.dark.mode.app.model.ColorsJson
import com.jans.rv.shimmer.dark.mode.app.model.Module
import kotlin.math.log

class FirstScreen : AppCompatActivity() {



    private lateinit var btnProduct:LinearLayout
    private lateinit var btnUsers:LinearLayout
    private lateinit var btnCategory:LinearLayout
    private lateinit var btnCart:LinearLayout
    private lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        context = this@FirstScreen

        btnProduct = findViewById(R.id.itemProducts)
        btnUsers = findViewById(R.id.itemUsers)
        btnCategory = findViewById(R.id.itemCategories)
        btnCart = findViewById(R.id.itemCarts)

        val list:List<Module> = getListAllModules().modules

        tagLog("myTag123",list.toString())

        btnProduct.setOnClickListener{
            startActivity(Intent(context,ProductScreen::class.java)
                .putExtra("LightColor", list[0].dayColors.primaryColor)
                .putExtra("DarkColor", list[0].nightColors.primaryColor)
            )
        }

        btnUsers.setOnClickListener{
            startActivity(Intent(context,UserScreen::class.java)
                .putExtra("LightColor", list[1].dayColors.primaryColor)
                .putExtra("DarkColor", list[1].nightColors.primaryColor)
            )
        }

        btnCategory.setOnClickListener{
            startActivity(Intent(context,CategoryScreen::class.java)
                .putExtra("LightColor", list[2].dayColors.primaryColor)
                .putExtra("DarkColor", list[2].nightColors.primaryColor)
            )
        }

        btnCart.setOnClickListener{
            startActivity(Intent(context,CartScreen::class.java)
                .putExtra("LightColor", list[3].dayColors.primaryColor)
                .putExtra("DarkColor", list[3].nightColors.primaryColor)
            )
        }

//        // Dynamically create color resources for both light and dark themes
//        createColorResource(lightPrimaryColor, "lightPrimaryColor")
//        createColorResource(darkPrimaryColor, "darkPrimaryColor")
//
//        // Now you can use these colors in your application
//        val lightPrimaryColorValue = getColor(R.color.lightPrimaryColor)
//        val darkPrimaryColorValue = getColor(R.color.darkPrimaryColor)





        // Access module configurations
//        moduleConfig.modules.forEach { module ->
//            tagLog("list123","-------------------------------------")
//            tagLog("list123","Module Name: ${module.moduleName}")
//            tagLog("list123","Day Colors:")
//            tagLog("list123","  Primary Color: ${module.dayColors.primaryColor}")
//            tagLog("list123","  Secondary Color: ${module.dayColors.secondaryColor}")
//            tagLog("list123","  Text Color: ${module.dayColors.textColor}")
//            tagLog("list123","  Background Color: ${module.dayColors.backgroundColor}")
//            tagLog("list123","Night Colors:")
//            tagLog("list123","  Primary Color: ${module.nightColors.primaryColor}")
//            tagLog("list123","  Secondary Color: ${module.nightColors.secondaryColor}")
//            tagLog("list123","  Text Color: ${module.nightColors.textColor}")
//            tagLog("list123","  Background Color: ${module.nightColors.backgroundColor}")
//        }


    }

    private fun getListAllModules(): ColorsJson{
        val inputStream = resources.openRawResource(R.raw.colors_json)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(jsonString, ColorsJson::class.java)
    }

    private fun tagLog(tag:String,message: String){
        Log.d(tag,message)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(context,SettingScreen::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}