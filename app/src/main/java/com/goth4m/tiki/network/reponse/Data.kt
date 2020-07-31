package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("discount_percent")
    var discountPercent: Int?,
    @SerializedName("from_date")
    var fromDate: String?,
    @SerializedName("product")
    var product: Product?,
    @SerializedName("progress")
    var progress: Progress?,
    @SerializedName("special_from_date")
    var specialFromDate: Int?,
    @SerializedName("special_price")
    var specialPrice: Int?,
    @SerializedName("special_to_date")
    var specialToDate: Int?,
    @SerializedName("status")
    var status: Int?,
    @SerializedName("tags")
    var tags: String?,
    @SerializedName("url")
    var url: String?
)