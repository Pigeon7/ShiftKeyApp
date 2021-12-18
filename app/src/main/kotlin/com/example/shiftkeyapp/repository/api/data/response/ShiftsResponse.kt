package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName

data class ShiftsResponse(
    @SerializedName("data")
    val dailyShifts: List<DailyShifts>,
    @SerializedName("links")
    val links: List<Any>,
    @SerializedName("meta")
    val meta: Meta
)