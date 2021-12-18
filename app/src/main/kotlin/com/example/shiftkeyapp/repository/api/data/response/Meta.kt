package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lng")
    val longitude: Double
)