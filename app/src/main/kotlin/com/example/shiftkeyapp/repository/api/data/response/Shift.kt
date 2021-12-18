package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName

data class Shift(
    @SerializedName("covid")
    val isCovid: Boolean,
    @SerializedName("end_time")
    val endTime: String,
    @SerializedName("facility_type")
    val facilityType: FacilityType,
    @SerializedName("localized_specialty")
    val localizedSpecialty: LocalizedSpecialty,
    @SerializedName("normalized_end_date_time")
    val normalizedEndDateTime: String,
    @SerializedName("normalized_start_date_time")
    val normalizedStartDateTime: String,
    @SerializedName("premium_rate")
    val premiumRate: Boolean,
    @SerializedName("shift_id")
    val shiftId: Int,
    @SerializedName("shift_kind")
    val shiftKind: String,
    @SerializedName("skill")
    val skill: Skill,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("within_distance")
    val withinDistance: Int
)