package com.example.shiftkeyapp.repository.retrofit.data

data class Shift(
    val covid: Boolean,
    val end_time: String,
    val facility_type: FacilityType,
    val localized_specialty: LocalizedSpecialty,
    val normalized_end_date_time: String,
    val normalized_start_date_time: String,
    val premium_rate: Boolean,
    val shift_id: Int,
    val shift_kind: String,
    val skill: Skill,
    val start_time: String,
    val timezone: String,
    val within_distance: Int
)