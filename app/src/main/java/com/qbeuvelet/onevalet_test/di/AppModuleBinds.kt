package com.qbeuvelet.onevalet_test.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import com.qbeuvelet.onevalet_test.base.ResourcesService
import com.qbeuvelet.onevalet_test.base.ResourcesServiceInterface
import com.qbeuvelet.onevalet_test.provider.DevicesProviderService
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.provider.FavoritesService
import com.qbeuvelet.onevalet_test.provider.FavoritesServiceInterface
import com.qbeuvelet.onevalet_test.ui.device_detail.DeviceDetailViewModel
import com.qbeuvelet.onevalet_test.ui.favorites.FavoritesViewModel
import com.qbeuvelet.onevalet_test.ui.home.HomeViewModel
import com.qbeuvelet.onevalet_test.ui.settings.SettingsViewModel
import dagger.multibindings.IntoMap

@Module
abstract class AppModuleBinds {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewmodel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeviceDetailViewModel::class)
    abstract fun bindDeviceDetailViewModel(viewmodel: DeviceDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoritesViewModel(viewmodel: FavoritesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSetingsViewModel(viewmodel: SettingsViewModel): ViewModel

    @Binds
    abstract fun providesDevicesProviderService(devicesProviderService: DevicesProviderService): DevicesProviderServiceInterface

    @Binds
    abstract fun providesResourcesService(resourcesService: ResourcesService): ResourcesServiceInterface

    @Binds
    abstract fun providesFavoritesService(favoritesService: FavoritesService): FavoritesServiceInterface

}