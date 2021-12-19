package com.example.shiftkeyapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.shiftkeyapp.repository.ShiftsRepo
import com.example.shiftkeyapp.repository.ShiftsRepoImpl
import com.example.shiftkeyapp.repository.api.BaseUrls.BASE_API_URL
import com.example.shiftkeyapp.repository.api.ShiftsApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideSharedPrefs(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences("AppPrefs", MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideGson() : Gson{
        return Gson()
    }

}