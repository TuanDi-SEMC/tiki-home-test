package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Tab(
    @SerializedName("active")
    var active: Boolean?,
    @SerializedName("display")
    var display: String?,
    @SerializedName("from_date")
    var fromDate: String?,
    @SerializedName("query_value")
    var queryValue: Int?,
    @SerializedName("to_date")
    var toDate: String?
)