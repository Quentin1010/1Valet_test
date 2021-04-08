package com.qbeuvelet.onevalet_test.di

import dagger.Binds
import dagger.Module
import com.qbeuvelet.onevalet_test.base.ResourcesService
import com.qbeuvelet.onevalet_test.base.ResourcesServiceInterface

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun providesResourcesService(resourcesService: ResourcesService): ResourcesServiceInterface
}