package com.example.cilenius.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoimNameContainerDto (
    @SerializedName("CoinInfo")
    @Expose
    val coinNameDto: CoinNameDto? = null
)