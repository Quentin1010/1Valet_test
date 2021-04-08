package com.qbeuvelet.onevalet_test.provider

import com.qbeuvelet.onevalet_test.model.Device

interface FavoritesServiceInterface {

    fun addDevice(device: Device)
    fun removeDevice(device: Device)
    fun getFavorites(): List<String>
    fun clearAll()

}