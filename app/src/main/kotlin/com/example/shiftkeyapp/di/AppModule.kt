package com.example.shiftkeyapp.di

import com.example.shiftkeyapp.repository.retrofit.BaseUrls.BASE_API_URL
import com.example.shiftkeyapp.repository.retrofit.ShiftsApi
import com.example.shiftkeyapp.repository.retrofit.data.ShiftsResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShiftsApi(): ShiftsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_API_URL)
            .build()
            .create(ShiftsApi::class.java)
    }

}