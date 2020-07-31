package com.goth4m.tiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.goth4m.tiki.network.Resource
import com.goth4m.tiki.network.reponse.Banner
import com.goth4m.tiki.network.reponse.Data
import com.goth4m.tiki.network.reponse.QuickLinkList
import com.goth4m.tiki.repo.HomeRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel() {
    val banners = MutableLiveData<Resource<List<Banner>>>()
    val quickLinks = MutableLiveData<Resource<QuickLinkList>>()
    val flashDeals = MutableLiveData<Resource<List<Data>>>()

    fun getBanner() {
        banners.value = Resource.Loading()
        quickLinks.value = Resource.Loading()
        viewModelScope.launch {
            val bannerRes = async {
                repository.getBanners()
            }
            val quickLinkRes = async { repository.getQuickLinks() }

            combine(
                bannerRes.await(),
                quickLinkRes.await()
            )
        }
    }

    private fun combine(bannerRes: Resource<List<Banner>>, quickLinkRes: Resource<QuickLinkList>) {
        if (bannerRes is Resource.Success || quickLinkRes is Resource.Success) {
            banners.value = bannerRes
            quickLinks.value = quickLinkRes

            getFlashDeals()
        }
    }


    private fun getFlashDeals() {
        flashDeals.value = Resource.Loading()
        viewModelScope.launch {
            flashDeals.value = repository.getHotDeals()
        }
    }
}