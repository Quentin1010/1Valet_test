package com.qbeuvelet.onevalet_test.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.qbeuvelet.onevalet_test.base.BaseApp
import com.qbeuvelet.onevalet_test.base.BaseFragment
import com.qbeuvelet.onevalet_test.databinding.FragmentHomeBinding
import com.qbeuvelet.onevalet_test.ui.device.DeviceRecyclerViewAdapter

class HomeFragment : BaseFragment() {

    override val viewModel by viewModels<HomeViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(layoutInflater)

        val deviceAdapter = DeviceRecyclerViewAdapter(viewModel)

        binding.adapter = deviceAdapter

        viewModel.devices.observe(viewLifecycleOwner) {
            deviceAdapter.submitList(it)
        }

        return binding.root
    }
}