package com.qbeuvelet.onevalet_test.ui.settings

import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.base.SingleLiveEvent
import com.qbeuvelet.onevalet_test.provider.FavoritesServiceInterface
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val favoritesService: FavoritesServiceInterface
): BaseViewModel() {

    val onResetClickObservable = SingleLiveEvent<Void>()

    fun onResetFavoritesClick() {
        favoritesService.clearAll()
        onResetClickObservable.call()
    }
}