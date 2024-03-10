package com.jans.rv.shimmer.dark.mode.app.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

data class ColorsJson(
    @SerializedName("modules")
    @Expose
    var modules: List<Module> = listOf()
)

data class Module(
    @SerializedName("module_name")
    @Expose
    var moduleName: String = "",
    @SerializedName("day_colors")
    @Expose
    var dayColors: DayColors = DayColors(),
    @SerializedName("night_colors")
    @Expose
    var nightColors: NightColors = NightColors()
):Serializable

 data class DayColors(
    @SerializedName("primary_color")
    @Expose
    var primaryColor: String = "",
    @SerializedName("secondary_color")
    @Expose
    var secondaryColor: String = "",
    @SerializedName("text_color")
    @Expose
    var textColor: String = "",
    @SerializedName("background_color")
    @Expose
    var backgroundColor: String = ""
):Serializable

data class NightColors(
    @SerializedName("primary_color")
    @Expose
    var primaryColor: String = "",
    @SerializedName("secondary_color")
    @Expose
    var secondaryColor: String = "",
    @SerializedName("text_color")
    @Expose
    var textColor: String = "",
    @SerializedName("background_color")
    @Expose
    var backgroundColor: String = ""
):Serializable