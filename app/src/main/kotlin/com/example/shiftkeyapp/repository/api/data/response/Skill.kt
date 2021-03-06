package com.example.shiftkeyapp.repository.api.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Skill(
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Serializable