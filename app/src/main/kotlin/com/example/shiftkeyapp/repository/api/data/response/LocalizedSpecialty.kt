package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName

data class LocalizedSpecialty(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("specialty")
    val specialty: Specialty,
    @SerializedName("specialty_id")
    val specialtyId: Int,
    @SerializedName("state_id")
    val stateId: Int
)