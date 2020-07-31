package com.goth4m.tiki

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by TuanTM on 7/30/20.
 */
fun ImageView.loadBanner(url: String?) {
    Glide.with(this).load(url).into(this)
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}