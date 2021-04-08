package com.qbeuvelet.onevalet_test.provider

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.qbeuvelet.onevalet_test.R
import com.qbeuvelet.onevalet_test.base.ResourcesServiceInterface
import com.qbeuvelet.onevalet_test.model.Device
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList
import javax.inject.Inject

class DevicesProviderService @Inject constructor(
    private val resourcesService: ResourcesServiceInterface
): DevicesProviderServiceInterface {

    override fun getDevices(): List<Device> {
        try {
            val devices = resourcesService.getResources().openRawResource(R.raw.devices)
            val reader = BufferedReader(InputStreamReader(devices, "UTF-8"))
            val listType = object : TypeToken<ArrayList<Device>>() {}.type
            return Gson().fromJson(reader, listType)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}