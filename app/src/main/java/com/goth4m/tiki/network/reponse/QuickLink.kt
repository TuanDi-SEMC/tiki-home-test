package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class QuickLink(
    @SerializedName("authentication")
    var authentication: Boolean?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("web_url")
    var webUrl: String?
)