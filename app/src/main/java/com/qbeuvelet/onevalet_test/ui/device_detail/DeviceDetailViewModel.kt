package com.qbeuvelet.onevalet_test.ui.device_detail

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.qbeuvelet.onevalet_test.Constants
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.model.Device
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import javax.inject.Inject

class DeviceDetailViewModel @Inject constructor(
    private val devicesProviderService: DevicesProviderServiceInterface,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel() {

    val device = MutableLiveData<Device>()
    val isFavorite = MutableLiveData(false)

    fun updateDevice(argId: String) {
        device.value = devicesProviderService.getDevices().find { it.id == argId }

        val favorites = sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, mutableSetOf())
        isFavorite.value = favorites?.contains(device.value?.id) ?: false
    }

    fun onFavoriteClick(isChecked: Boolean) {
        isFavorite.value = isChecked

        val favorites = sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, mutableSetOf())

        favorites?.remove(device.value?.id)
        if (isFavorite.value == true) {
            favorites?.add(device.value?.id)
        }

        sharedPreferences.edit().putStringSet(Constants.FAVORITE_LIST_KEY, favorites).apply()
    }
}