package com.qbeuvelet.onevalet_test.ui.favorites

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.qbeuvelet.onevalet_test.Constants
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.ui.device.OnDeviceItemClickInterface
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val devicesProviderService: DevicesProviderServiceInterface,
    private val sharedPreferences: SharedPreferences
): BaseViewModel(), OnDeviceItemClickInterface {

    val devices = MutableLiveData<List<Device>>(listOf())

    init {
        refreshList()
    }

    fun refreshList(){
        val favorites = sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, setOf())
        devices.value = devicesProviderService.getDevices().filter { favorites?.contains(it.id) == true }
    }

    override fun onItemClick(device: Device) {
        navigate(Destination.DETAIL_DEVICE(device.id))
    }
}