package com.example.currencyconverter.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.currencyconverter.data.ApiConstants
import com.example.currencyconverter.data.DataApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context))
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideTmdbApi(retrofit: Retrofit): DataApi = retrofit.create(
        DataApi::class.java)

}