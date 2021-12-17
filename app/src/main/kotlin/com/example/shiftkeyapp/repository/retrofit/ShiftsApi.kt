package com.example.shiftkeyapp.repository.retrofit

import com.example.shiftkeyapp.repository.retrofit.data.ShiftsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ShiftsApi {

    @GET("available_shifts")
    suspend fun getShifts(
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Accept") accept: String = "application/json",
        @Query("address") address: String,
        @Query("offset") offset: Int
    ): ShiftsResponse
}