package com.qbeuvelet.onevalet_test.provider

import android.content.SharedPreferences
import com.qbeuvelet.onevalet_test.Constants
import com.qbeuvelet.onevalet_test.model.Device
import javax.inject.Inject

class FavoritesService @Inject constructor(
    private val sharedPreferences: SharedPreferences
): FavoritesServiceInterface {

    override fun addDevice(device: Device) {
        val favorites = sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, mutableSetOf()).orEmpty().toMutableSet()
        if(!favorites.contains(device.id)) {
            favorites.add(device.id)
        }

        sharedPreferences.edit().putStringSet(Constants.FAVORITE_LIST_KEY, favorites).apply()
    }

    override fun removeDevice(device: Device) {
        val favorites = sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, mutableSetOf()).orEmpty().toMutableSet()

        favorites.removeAll {
            device.id == it
        }

        sharedPreferences.edit().putStringSet(Constants.FAVORITE_LIST_KEY, favorites).apply()
    }

    override fun getFavorites(): List<String> {
        return sharedPreferences.getStringSet(Constants.FAVORITE_LIST_KEY, mutableSetOf()).orEmpty().toList()
    }

    override fun clearAll() {
        sharedPreferences.edit().putStringSet(Constants.FAVORITE_LIST_KEY, setOf()).apply()
    }
}