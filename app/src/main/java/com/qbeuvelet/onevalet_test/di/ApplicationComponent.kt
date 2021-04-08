package com.qbeuvelet.onevalet_test.di

import com.qbeuvelet.onevalet_test.ui.home.HomeFragment
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

    fun inject(fragment: HomeFragment)

}
