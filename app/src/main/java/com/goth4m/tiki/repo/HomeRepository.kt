package com.goth4m.tiki.repo

import com.goth4m.tiki.network.Resource
import com.goth4m.tiki.network.api.HomeApi
import com.goth4m.tiki.network.reponse.Banner
import com.goth4m.tiki.network.reponse.Data
import com.goth4m.tiki.network.reponse.QuickLinkList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class HomeRepository constructor(
    private val api: HomeApi
) {

    suspend fun getBanners(): Resource<List<Banner>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getBanners()
                Resource.Success(response.data ?: arrayListOf())
            } catch (e: HttpException) {
                Resource.Error(e.message())
            } catch (ex: Throwable) {
                Resource.Error(ex.message ?: "error")
            }
        }
    }

    suspend fun getQuickLinks(): Resource<QuickLinkList> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getQuickLinks()
                Resource.Success(response)
            } catch (e: HttpException) {
                Resource.Error(e.message())
            } catch (ex: Throwable) {
                Resource.Error(ex.message ?: "error")
            }
        }
    }

    suspend fun getHotDeals(): Resource<List<Data>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getFlashDeals()
                val data = response.data
                Resource.Success(data ?: arrayListOf())
            } catch (e: HttpException) {
                Resource.Error(e.message())
            } catch (ex: Throwable) {
                Resource.Error(ex.message ?: "error")
            }
        }
    }
}