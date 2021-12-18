package com.example.shiftkeyapp.repository

import com.example.shiftkeyapp.repository.api.data.request.ShiftRequestType
import com.example.shiftkeyapp.repository.api.data.response.DailyShifts

interface ShiftsRepo {

    suspend fun getShifts(
        address: String,
        start: String? = null,
        end: String? = null,
        offset: ShiftRequestType? = null,
        radius: Int? = null
    ): List<DailyShifts>
}