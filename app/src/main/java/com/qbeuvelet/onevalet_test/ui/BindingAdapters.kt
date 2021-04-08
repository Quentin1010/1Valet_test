package com.qbeuvelet.onevalet_test.ui

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.BindingAdapter
import com.qbeuvelet.onevalet_test.model.Device

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

}