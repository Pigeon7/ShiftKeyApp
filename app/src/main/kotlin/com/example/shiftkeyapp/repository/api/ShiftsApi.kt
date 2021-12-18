package com.example.shiftkeyapp.repository.api

import com.example.shiftkeyapp.repository.api.data.request.ShiftRequestType
import com.example.shiftkeyapp.repository.api.data.response.ShiftsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ShiftsApi {

    @GET("available_shifts")
    suspend fun getShifts(
//        @Header("Content-Type") contentType: String = "application/json",
//        @Header("Accept") accept: String = "application/json",
        @Query("address") address: String,
        @Query("start") start: String? = null,             //YYYY-MM-DD and ISO 8601 date time.
        @Query("type") offset: String = ShiftRequestType.WEEK.toString(),                 //YYYY-MM-DD and ISO 8601 date time.
        @Query("radius") radius: Int? = null,              // Defaults to 150. Distance is in miles.
    ): ShiftsResponse
}