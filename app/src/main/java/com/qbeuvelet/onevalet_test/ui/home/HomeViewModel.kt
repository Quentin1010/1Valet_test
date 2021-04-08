package com.qbeuvelet.onevalet_test.ui.home

import androidx.lifecycle.MutableLiveData
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.ui.device.OnClickInterface
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    devicesProviderService: DevicesProviderServiceInterface
): BaseViewModel(), OnClickInterface {

    val devices = MutableLiveData<List<Device>>(listOf())

    init {
        devices.value = devicesProviderService.getDevices()
    }

    override fun onItemClick(device: Device) {
        TODO("Not yet implemented")
    }
}