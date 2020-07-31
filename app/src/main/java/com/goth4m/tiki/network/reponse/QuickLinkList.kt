package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class QuickLinkList(
    @SerializedName("data")
    var `data`: List<List<QuickLink>>?
)