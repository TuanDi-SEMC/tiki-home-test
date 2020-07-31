package com.goth4m.tiki.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import com.goth4m.tiki.R
import com.goth4m.tiki.databinding.FragmentHomeBinding
import com.goth4m.tiki.gone
import com.goth4m.tiki.invisible
import com.goth4m.tiki.network.Resource
import com.goth4m.tiki.network.reponse.Banner
import com.goth4m.tiki.network.reponse.Data
import com.goth4m.tiki.network.reponse.QuickLink
import com.goth4m.tiki.visible
import kotlin.reflect.KClass

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private val mBanners by lazy { arrayListOf<Banner>() }
    private val mBannerAdapter by lazy {
        BannerAdapter(mBanners)
    }
    private val mTopLinks by lazy { arrayListOf<QuickLink>() }
    private val mTopLinkAdapter by lazy {
        QuickLinkAdapter(mTopLinks)
    }
    private val mBotLinks by lazy { arrayListOf<QuickLink>() }
    private val mBotLinkAdapter by lazy {
        QuickLinkAdapter(mBotLinks)
    }
    private val mFlashDeals by lazy { arrayListOf<Data>() }
    private val mFlashDealAdapter by lazy {
        ProductAdapter(mFlashDeals)
    }

    override fun initView() {
        mViewModel.getBanner()
    }

    override fun setVariableBinding() {
        binding.apply {
            vpBanner.apply {
                adapter = mBannerAdapter
            }

            rcvQuickLink1.apply {
                adapter = mTopLinkAdapter
            }

            rcvQuickLink2.apply {
                adapter = mBotLinkAdapter
            }
            rcvFlashDeal.apply { adapter = mFlashDealAdapter }
            refreshLayout.setOnRefreshListener {
                refreshLayout.isRefreshing = false
                flashDealContainer.invisible()
                mViewModel.getBanner()
            }
        }
        mViewModel.apply {
            banners.observe(this@HomeFragment, Observer {
                when (it) {
                    is Resource.Loading -> {
                        binding.apply {
                            bannerProgress.visible()
                            vpBanner.invisible()
                        }

                    }
                    is Resource.Success -> {
                        binding.apply {
                            bannerProgress.gone()
                            vpBanner.visible()
                        }
                        mBanners.clear()
                        mBanners.addAll(it.data)
                        mBannerAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        binding.apply {
                            bannerProgress.gone()
                            vpBanner.invisible()
                        }
//                        Toast.makeText(requireContext(), it.exception, Toast.LENGTH_LONG).show()
                    }
                }
            })

            quickLinks.observe(this@HomeFragment, Observer {
                when (it) {
                    is Resource.Loading -> {
                        binding.apply {
                            quickLinkProgress.visible()
                            rcvQuickLink1.invisible()
                            rcvQuickLink2.invisible()
                        }

                    }
                    is Resource.Success -> {
                        binding.apply {
                            quickLinkProgress.gone()
                            rcvQuickLink1.visible()
                            rcvQuickLink2.visible()
                        }
                        val data = it.data
                        mTopLinks.clear()
                        mTopLinks.addAll(data.data?.get(0) ?: arrayListOf())
                        mTopLinkAdapter.notifyDataSetChanged()

                        mBotLinks.clear()
                        mBotLinks.addAll(data.data?.get(1) ?: arrayListOf())
                        mBotLinkAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        binding.apply {
                            quickLinkProgress.gone()
                            rcvQuickLink1.invisible()
                            rcvQuickLink2.invisible()
                        }
//                        Toast.makeText(requireContext(), it.exception, Toast.LENGTH_LONG).show()
                    }
                }
            })
            flashDeals.observe(this@HomeFragment, Observer {
                when (it) {
                    is Resource.Loading -> {
                        binding.apply {
                            flashDealProgress.visible()
                            flashDealContainer.invisible()
                        }

                    }
                    is Resource.Success -> {
                        binding.apply {
                            flashDealProgress.gone()
                            flashDealContainer.visible()
                        }
                        val data = it.data
                        mFlashDeals.clear()
                        mFlashDeals.addAll(data)
                        mFlashDealAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        binding.apply {
                            flashDealProgress.gone()
                            flashDealContainer.invisible()
                        }
                        Toast.makeText(requireContext(), it.exception, Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_home
    override val clazz: KClass<HomeViewModel>
        get() = HomeViewModel::class
}