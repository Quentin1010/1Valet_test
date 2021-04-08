package com.qbeuvelet.onevalet_test.ui.device_detail

import androidx.lifecycle.MutableLiveData
import com.qbeuvelet.onevalet_test.Constants
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.provider.FavoritesServiceInterface
import javax.inject.Inject

class DeviceDetailViewModel @Inject constructor(
    private val devicesProviderService: DevicesProviderServiceInterface,
    private val favoritesService: FavoritesServiceInterface
) : BaseViewModel() {

    val device = MutableLiveData<Device>()
    val isFavorite = MutableLiveData(false)

    fun updateDevice(argId: String) {
        device.value = devicesProviderService.getDevices().find { it.id == argId }

        val favorites = favoritesService.getFavorites()
        isFavorite.value = favorites.contains(device.value?.id)
    }

    fun onFavoriteClick(isChecked: Boolean) {
        isFavorite.value = isChecked

        device.value?.let {
            if(isChecked){
                favoritesService.addDevice(it)
            }
            else {
                favoritesService.removeDevice(it)
            }
        }
    }
}