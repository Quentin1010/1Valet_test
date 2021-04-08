package com.qbeuvelet.onevalet_test.ui.settings

import android.content.SharedPreferences
import com.qbeuvelet.onevalet_test.Constants
import com.qbeuvelet.onevalet_test.base.BaseViewModel
import com.qbeuvelet.onevalet_test.base.SingleLiveEvent
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
): BaseViewModel() {

    val onResetClickObservable = SingleLiveEvent<Void>()

    fun onResetFavoritesClick() {
        sharedPreferences.edit().putStringSet(Constants.FAVORITE_LIST_KEY, setOf()).apply()
        onResetClickObservable.call()
    }
}