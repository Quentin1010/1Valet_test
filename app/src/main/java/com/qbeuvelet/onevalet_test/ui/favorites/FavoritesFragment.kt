package com.qbeuvelet.onevalet_test.ui.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.qbeuvelet.onevalet_test.R
import com.qbeuvelet.onevalet_test.base.BaseApp
import com.qbeuvelet.onevalet_test.base.BaseFragment
import com.qbeuvelet.onevalet_test.databinding.FragmentFavoritesBinding
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.navigation.NavigationCommand
import com.qbeuvelet.onevalet_test.ui.device.DeviceRecyclerViewAdapter
import com.qbeuvelet.onevalet_test.ui.home.HomeFragmentDirections

class FavoritesFragment : BaseFragment() {

    override val viewModel by viewModels<FavoritesViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesBinding.inflate(layoutInflater)

        viewModel.refreshList()

        val deviceAdapter = DeviceRecyclerViewAdapter(viewModel)

        binding.adapter = deviceAdapter

        viewModel.devices.observe(viewLifecycleOwner) {
            deviceAdapter.submitList(it)
        }

        return binding.root
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination){
            Destination.UP -> onBackPressed()
            is Destination.DETAIL_DEVICE -> findNavController().navigate(FavoritesFragmentDirections.favoritesToDetail(command.destination.deviceId))
        }
    }

    override fun onBackPressed() {
        findNavController().navigate(R.id.nav_home)
    }
}