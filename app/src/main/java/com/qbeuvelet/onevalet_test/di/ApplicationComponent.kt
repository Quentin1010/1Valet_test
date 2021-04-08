package com.qbeuvelet.onevalet_test.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (
    modules = [
        AppModule::class,
        AppModuleBinds::class,
        ViewModelBuilderModule::class
])
interface ApplicationComponent {

}
