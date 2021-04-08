package com.qbeuvelet.onevalet_test.model

import com.google.gson.annotations.SerializedName

data class Device (
    @SerializedName("Id")
    val id: String,

    @SerializedName("Type")
    val type: DeviceType,

    @SerializedName("Price")
    val price: Long,

    @SerializedName("Currency")
    val currency: String,

    @SerializedName("imageUrl")
    val imageURL: String,

    @SerializedName("Title")
    val title: String,

    @SerializedName("Description")
    val description: String
)
