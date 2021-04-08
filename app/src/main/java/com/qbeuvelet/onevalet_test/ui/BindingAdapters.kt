package com.qbeuvelet.onevalet_test.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter
import com.qbeuvelet.onevalet_test.model.Device
import com.squareup.picasso.Picasso

object BindingAdapters {

    @BindingAdapter(value = ["setAdapter"])
    @JvmStatic
    fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
        this.run {
            this.setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    @BindingAdapter(value = ["priceFormat", "device"])
    @JvmStatic
    fun TextView.bindDevicePrice(priceFormat: String, device: Device){
        this.text = String.format(priceFormat, device.price, device.currency)
    }

    @BindingAdapter(value = ["simpleFormat", "simpleFormatArgument"])
    @JvmStatic
    fun TextView.bindSimpleFormat(simpleFormat: String, arg: String){
        this.text = String.format(simpleFormat, arg)
    }

    @BindingAdapter(value = ["twoFormat", "oneFormatArgument", "twoFormatArgument"])
    @JvmStatic
    fun TextView.bindTwoFormat(twoFormat: String, first: String, second: String){
        this.text = String.format(twoFormat, first, second)
    }

    @BindingAdapter(value = ["loadImage"])
    @JvmStatic
    fun ImageView.bindImage(url: String? = "") {
        Picasso.with(this.context)
            .load(url)
            .into(this)
    }

}