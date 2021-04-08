package com.qbeuvelet.onevalet_test.ui.device_detail

import androidx.lifecycle.MutableLiveData
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.ui.device.OnDeviceItemClickInterface
import javax.inject.Inject

class DeviceDetailViewModel @Inject constructor(
    private val devicesProviderService: DevicesProviderServiceInterface
): BaseViewModel() {

    val device = MutableLiveData<Device>()
    val isFavorite = MutableLiveData(false)

    fun updateDevice(argId: String){
        device.value = devicesProviderService.getDevices().find { it.id == argId }
        isFavorite.value = device.value?.isFavorite ?: false
    }
}