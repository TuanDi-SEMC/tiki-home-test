package com.goth4m.tiki.network.reponse


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("badges")
    var badges: List<Badge>?,
    @SerializedName("discount")
    var discount: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("inventory")
    var inventory: Inventory?,
    @SerializedName("is_flower")
    var isFlower: Boolean?,
    @SerializedName("is_fresh")
    var isFresh: Boolean?,
    @SerializedName("is_gift_card")
    var isGiftCard: Boolean?,
    @SerializedName("is_visible")
    var isVisible: Boolean?,
    @SerializedName("list_price")
    var listPrice: Int?,
    @SerializedName("master_id")
    var masterId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("order_count")
    var orderCount: Int?,
    @SerializedName("price")
    var price: Int?,
    @SerializedName("price_prefix")
    var pricePrefix: String?,
    @SerializedName("rating_average")
    var ratingAverage: Int?,
    @SerializedName("review_count")
    var reviewCount: Int?,
    @SerializedName("seller_product_id")
    var sellerProductId: Int?,
    @SerializedName("sku")
    var sku: Any?,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String?,
    @SerializedName("url_attendant_input_form")
    var urlAttendantInputForm: String?,
    @SerializedName("url_path")
    var urlPath: String?
)