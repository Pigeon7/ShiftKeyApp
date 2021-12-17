package com.example.shiftkeyapp.repository.retrofit

import com.example.shiftkeyapp.repository.retrofit.data.request.ShiftRequestType
import com.example.shiftkeyapp.repository.retrofit.data.response.ShiftsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ShiftsApi {

    @GET("available_shifts")
    suspend fun getShifts(
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Accept") accept: String = "application/json",
        @Query("address") address: String,
        @Query("start") start: String?,             //YYYY-MM-DD and ISO 8601 date time.
        @Query("end") end: String?,                 //YYYY-MM-DD and ISO 8601 date time.
        @Query("type") offset: ShiftRequestType?,
        @Query("radius") radius: Int?,              // Defaults to 150. Distance is in miles.
    ): ShiftsResponse
}