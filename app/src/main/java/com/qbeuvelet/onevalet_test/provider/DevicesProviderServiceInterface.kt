package com.qbeuvelet.onevalet_test.provider

import com.qbeuvelet.onevalet_test.model.Device

interface DevicesProviderServiceInterface {

    fun getDevices(): List<Device>

}