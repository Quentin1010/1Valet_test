package com.qbeuvelet.onevalet_test.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.ui.device.OnDeviceItemClickInterface
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val devicesProviderService: DevicesProviderServiceInterface
): BaseViewModel(), OnDeviceItemClickInterface {

    private val searchQuery = MutableLiveData("")

    val devices: LiveData<MutableList<Device>>
        get() = _devices

    private val _devices = Transformations.switchMap(searchQuery) { query ->
        MutableLiveData(devicesProviderService.getDevices().filter { it.title.startsWith(query, true)}.toMutableList())
    }

    fun updateSearchQuery(query: String){
        searchQuery.value = query
    }

    override fun onItemClick(device: Device) {
        navigate(Destination.DETAIL_DEVICE(device.id))
    }
}