package com.qbeuvelet.onevalet_test.di

import dagger.Binds
import dagger.Module
import com.qbeuvelet.onevalet_test.base.ResourcesService
import com.qbeuvelet.onevalet_test.base.ResourcesServiceInterface
import com.qbeuvelet.onevalet_test.provider.DevicesProviderService
import com.qbeuvelet.onevalet_test.provider.DevicesProviderServiceInterface

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun providesDevicesProviderService(devicesProviderService: DevicesProviderService): DevicesProviderServiceInterface

    @Binds
    abstract fun providesResourcesService(resourcesService: ResourcesService): ResourcesServiceInterface
}