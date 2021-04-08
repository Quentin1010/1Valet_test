package com.qbeuvelet.onevalet_test.model

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName
import com.qbeuvelet.onevalet_test.R

enum class DeviceType(val label: String, @DrawableRes val icon: Int) {
    @SerializedName("Sensor")
    SENSOR("Sensor", R.drawable.ic_sensor),

    @SerializedName("Thermostat")
    THERMOSTAT("Thermostat", R.drawable.ic_thermostat),

    @SerializedName("Lightbulb")
    LIGHTBULB("Lightbulb", R.drawable.ic_lightbulb),

    @SerializedName("Outlet")
    OUTLET("Outlet", R.drawable.ic_outlet)
}