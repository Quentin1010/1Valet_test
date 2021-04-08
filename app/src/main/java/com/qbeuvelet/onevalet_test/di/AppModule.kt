package com.qbeuvelet.onevalet_test.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.qbeuvelet.onevalet_test.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(
        Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
}
