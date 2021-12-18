package com.example.shiftkeyapp.repository

import com.example.shiftkeyapp.repository.api.ShiftsApi
import com.example.shiftkeyapp.repository.api.data.request.ShiftRequestType
import com.example.shiftkeyapp.repository.api.data.response.DailyShifts
import javax.inject.Inject

class ShiftsRepoImpl @Inject constructor(
    private val shiftsApi: ShiftsApi
) : ShiftsRepo {

    override suspend fun getShifts(
        address: String,
        start: String?,
        end: String?,
        offset: ShiftRequestType?,
        radius: Int?
    ): List<DailyShifts> {
        val result = shiftsApi.getShifts(
            address = "Dallas, TX"
        )
        return result.dailyShifts
    }
}