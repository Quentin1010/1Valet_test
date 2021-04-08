package com.qbeuvelet.onevalet_test.ui.device

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qbeuvelet.onevalet_test.databinding.DeviceItemListBinding
import com.qbeuvelet.onevalet_test.model.Device

class DeviceRecyclerViewAdapter (private val onClickInterface: OnClickInterface) : ListAdapter<Device, DeviceRecyclerViewAdapter.DeviceViewHolder>(Companion) {

    class DeviceViewHolder(val binding: DeviceItemListBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Device>() {
        override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Device, newItem: Device): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DeviceItemListBinding.inflate(layoutInflater, parent, false)

        return DeviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val currentDevice = getItem(position)
        holder.binding.device = currentDevice
        holder.binding.onClickInterface = onClickInterface
        holder.binding.executePendingBindings()
    }
}