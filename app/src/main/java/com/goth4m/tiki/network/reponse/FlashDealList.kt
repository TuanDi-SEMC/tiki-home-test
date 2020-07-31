package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class FlashDealList(
    @SerializedName("data")
    var `data`: List<Data>?,
    @SerializedName("tabs")
    var tabs: List<Tab>?,
    @SerializedName("version")
    var version: String?
)