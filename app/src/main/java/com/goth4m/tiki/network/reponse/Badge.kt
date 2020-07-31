package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("code")
    var code: String?
)