package com.qbeuvelet.onevalet_test.ui.home

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.qbeuvelet.onevalet_test.R
import com.qbeuvelet.onevalet_test.base.BaseApp
import com.qbeuvelet.onevalet_test.base.BaseFragment
import com.qbeuvelet.onevalet_test.databinding.FragmentHomeBinding
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.navigation.NavigationCommand
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

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home, menu)
        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    viewModel.updateSearchQuery(query ?: "")
                    return true
                }
            })
        }
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination){
            Destination.UP -> onBackPressed()
            is Destination.DETAIL_DEVICE -> findNavController().navigate(HomeFragmentDirections.homeToDetail(command.destination.deviceId))
        }
    }

    override fun onBackPressed() {
        activity?.finish()
    }
}