package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Inventory(
    @SerializedName("fulfillment_type")
    var fulfillmentType: String?,
    @SerializedName("product_virtual_type")
    var productVirtualType: Any?
)