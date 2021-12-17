package com.example.shiftkeyapp.repository.retrofit.data.response

data class LocalizedSpecialty(
    val abbreviation: String,
    val id: Int,
    val name: String,
    val specialty: Specialty,
    val specialty_id: Int,
    val state_id: Int
)