package com.goth4m.tiki.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.goth4m.tiki.R
import com.goth4m.tiki.databinding.ItemQuickLinkBinding
import com.goth4m.tiki.loadBanner
import com.goth4m.tiki.network.reponse.QuickLink

/**
 * Created by TuanTM on 7/30/20.
 */

class QuickLinkAdapter(private val data: List<QuickLink>) :
    RecyclerView.Adapter<QuickLinkAdapter.QuickLinkVH>() {
    class QuickLinkVH(private val binding: ItemQuickLinkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quickLink: QuickLink) {
            binding.apply {
                img.loadBanner(quickLink.imageUrl)
                tvTitle.text = quickLink.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickLinkVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemQuickLinkBinding>(
            inflater,
            R.layout.item_quick_link,
            parent,
            false
        )
        return QuickLinkVH(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: QuickLinkVH, position: Int) {
        holder.bind(data[position])
    }
}