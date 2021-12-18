package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName

data class DailyShifts(
    @SerializedName("date")
    val date: String,
    @SerializedName("shifts")
    val shifts: List<Shift>
)