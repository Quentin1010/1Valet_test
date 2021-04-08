package com.qbeuvelet.onevalet_test.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import com.qbeuvelet.onevalet_test.base.ResourcesService
import com.qbeuvelet.onevalet_test.base.ResourcesServiceInterface
import com.qbeuvelet.onevalet_test.provider.DevicesProviderService
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface
import com.qbeuvelet.onevalet_test.ui.device_detail.DeviceDetailViewModel
import com.qbeuvelet.onevalet_test.ui.home.HomeViewModel
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
    abstract fun providesDevicesProviderService(devicesProviderService: DevicesProviderService): DevicesProviderServiceInterface

    @Binds
    abstract fun providesResourcesService(resourcesService: ResourcesService): ResourcesServiceInterface
}