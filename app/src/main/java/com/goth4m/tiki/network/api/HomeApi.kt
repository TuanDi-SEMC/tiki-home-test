package com.goth4m.tiki.network.api

import com.goth4m.tiki.network.reponse.BannerList
import com.goth4m.tiki.network.reponse.FlashDealList
import com.goth4m.tiki.network.reponse.QuickLinkList
import retrofit2.http.GET
import retrofit2.http.POST


interface HomeApi {
    @POST("v2/home/banners/v2")
    suspend fun getBanners(): BannerList

    @GET("shopping/v2/widgets/quick_link")
    suspend fun getQuickLinks(): QuickLinkList

    @GET("v2/widget/deals/hot")
    suspend fun getFlashDeals(): FlashDealList
}
