package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Progress(
    @SerializedName("percent")
    var percent: Double?,
    @SerializedName("qty")
    var qty: Int?,
    @SerializedName("qty_ordered")
    var qtyOrdered: Int?,
    @SerializedName("qty_remain")
    var qtyRemain: Int?,
    @SerializedName("status")
    var status: String?
)