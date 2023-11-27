package com.example.currencyconverter.di

import android.content.Context
import com.example.currencyconverter.data.di.DatabaseModule
import com.example.currencyconverter.data.di.RemoteModule
import com.example.currencyconverter.ui.analytics.AnalyticsViewModelFactory
import com.example.currencyconverter.ui.homeScreen.HomeViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(

    modules = [
        DatabaseModule::class,
        RemoteModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): AppComponent
    }

    fun analyticsViewModelsFactory(): AnalyticsViewModelFactory
    fun homeViewModelsFactory(): HomeViewModelFactory

}

