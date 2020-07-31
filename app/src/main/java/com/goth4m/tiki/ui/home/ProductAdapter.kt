package com.goth4m.tiki.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.goth4m.tiki.R
import com.goth4m.tiki.databinding.ItemProductBinding
import com.goth4m.tiki.loadBanner
import com.goth4m.tiki.network.reponse.Data
import java.text.NumberFormat
import java.util.*

/**
 * Created by TuanTM on 7/30/20.
 */

class ProductAdapter(private val data: List<Data>) :
    RecyclerView.Adapter<ProductAdapter.ProductVH>() {
    inner class ProductVH(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                img.loadBanner(data.product?.thumbnailUrl)
                progressBar.progress = 50f
                tvPrice.text = "${formatter.format(data.specialPrice)} ₫"
                tvDiscount.text = "-${data.discountPercent}%"
                tvSold.text = "Đã bán ${data.progress?.qtyOrdered}"
            }
        }
    }

    val formatter: NumberFormat = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemProductBinding>(
            inflater,
            R.layout.item_product,
            parent,
            false
        )
        return ProductVH(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(data[position])
    }
}