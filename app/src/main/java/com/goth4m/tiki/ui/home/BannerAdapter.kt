package com.goth4m.tiki.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.goth4m.tiki.R
import com.goth4m.tiki.databinding.ItemBannerBinding
import com.goth4m.tiki.loadBanner
import com.goth4m.tiki.network.reponse.Banner

/**
 * Created by TuanTM on 7/30/20.
 */

class BannerAdapter(private val data: List<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerVH>() {
    class BannerVH(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            binding.img.loadBanner(banner.mobileUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBannerBinding>(
            inflater,
            R.layout.item_banner,
            parent,
            false
        )
        return BannerVH(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BannerVH, position: Int) {
        holder.bind(data[position])
    }
}