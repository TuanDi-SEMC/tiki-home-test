package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("content")
    var content: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("mobile_url")
    var mobileUrl: String?,
    @SerializedName("ratio")
    var ratio: Double?,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?
)