package com.qbeuvelet.onevalet_test.base

import androidx.lifecycle.ViewModel
import com.qbeuvelet.onevalet_test.navigation.NavigationCommand
import com.qbeuvelet.onevalet_test.navigation.Destination

open class BaseViewModel: ViewModel() {

    val navigationCommands: SingleLiveEvent<NavigationCommand> =
        SingleLiveEvent()

    fun navigate(destination: Destination) {
        navigationCommands.postValue(NavigationCommand(destination))
    }

    fun navigateBack() {
        navigationCommands.postValue(NavigationCommand(Destination.UP))
    }

    open fun onBackPressed() {
        navigateBack()
    }
}