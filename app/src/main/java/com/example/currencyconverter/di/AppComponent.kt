package com.example.currencyconverter.di

import android.content.Context
import com.example.currencyconverter.activity.MainActivity
import com.example.currencyconverter.data.di.DatabaseModule
import com.example.currencyconverter.data.di.RemoteModule
import com.example.currencyconverter.ui.analytics.AnalyticsFragment
import com.example.currencyconverter.ui.homeScreen.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(

    modules = [
        DatabaseModule::class,
        RemoteModule::class,
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): AppComponent
    }

//    fun inject(loginActivity: MainActivity)
//    fun inject(homeFragment: HomeFragment)
//    fun inject(analyticsFragment: AnalyticsFragment)

    fun loginComponent(): LoginComponent.Factory
}

