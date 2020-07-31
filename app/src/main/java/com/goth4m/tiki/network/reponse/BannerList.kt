package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class BannerList(
    @SerializedName("data")
    var `data`: List<Banner>?
)