package com.example.shiftkeyapp.di

import com.example.shiftkeyapp.repository.ShiftsRepo
import com.example.shiftkeyapp.repository.ShiftsRepoImpl
import com.example.shiftkeyapp.repository.api.BaseUrls.BASE_API_URL
import com.example.shiftkeyapp.repository.api.ShiftsApi
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

    @Singleton
    @Provides
    fun provideShiftsRepository(shiftsApi: ShiftsApi): ShiftsRepo {
        return ShiftsRepoImpl(shiftsApi = shiftsApi)
    }

}