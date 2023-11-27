package com.example.currencyconverter.app

import android.app.Application
import com.example.currencyconverter.di.AppComponent
import com.example.currencyconverter.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .setContext(applicationContext)
            .build()

    }
}