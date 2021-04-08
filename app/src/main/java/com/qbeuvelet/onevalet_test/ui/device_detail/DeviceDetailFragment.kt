package com.qbeuvelet.onevalet_test.ui.device_detail

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.qbeuvelet.onevalet_test.R
import com.qbeuvelet.onevalet_test.base.BaseApp
import com.qbeuvelet.onevalet_test.base.BaseFragment
import com.qbeuvelet.onevalet_test.databinding.FragmentDeviceDetailBinding
import com.qbeuvelet.onevalet_test.databinding.FragmentHomeBinding
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.navigation.NavigationCommand
import com.qbeuvelet.onevalet_test.ui.device.DeviceRecyclerViewAdapter
import com.qbeuvelet.onevalet_test.ui.fixCheckStateOnIcon

class DeviceDetailFragment : BaseFragment() {

    private val args:DeviceDetailFragmentArgs by navArgs()

    override val viewModel by viewModels<DeviceDetailViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDeviceDetailBinding.inflate(layoutInflater)
        viewModel.updateDevice(args.deviceId)

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail, menu)
        menu.findItem(R.id.action_favorite).apply {
            fixCheckStateOnIcon()
            setOnMenuItemClickListener {
                isChecked
                true
            }
        }

        viewModel.isFavorite.observe(viewLifecycleOwner){
            menu.findItem(R.id.action_favorite).isChecked = it
        }
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination){
            Destination.UP -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        findNavController().navigateUp()
    }
}