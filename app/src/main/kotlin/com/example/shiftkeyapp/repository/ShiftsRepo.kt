package com.example.shiftkeyapp.repository

import com.example.shiftkeyapp.repository.api.data.request.ShiftRequestType

interface ShiftsRepo {

    suspend fun getShifts(
        address: String,
        start: String?,
        end: String?,
        offset: ShiftRequestType,
        radius: Int?
    )
}