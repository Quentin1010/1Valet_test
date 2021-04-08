package com.qbeuvelet.onevalet_test.di

import com.qbeuvelet.onevalet_test.ui.device_detail.DeviceDetailFragment
import com.qbeuvelet.onevalet_test.ui.favorites.FavoritesFragment
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
    fun inject(fragment: DeviceDetailFragment)
    fun inject(fragment: FavoritesFragment)

}
