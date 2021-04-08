package com.qbeuvelet.onevalet_test.ui.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.qbeuvelet.onevalet_test.R
import com.qbeuvelet.onevalet_test.base.BaseApp
import com.qbeuvelet.onevalet_test.base.BaseFragment
import com.qbeuvelet.onevalet_test.databinding.FragmentSettingsBinding
import com.qbeuvelet.onevalet_test.navigation.Destination
import com.qbeuvelet.onevalet_test.navigation.NavigationCommand

class SettingsFragment : BaseFragment() {

    override val viewModel by viewModels<SettingsViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingsBinding.inflate(layoutInflater)

        binding.viewModel = viewModel

        viewModel.onResetClickObservable.observe(viewLifecycleOwner) {
            Snackbar.make(requireActivity().findViewById(android.R.id.content), R.string.favorites_cleared_snackbar, Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination){
            Destination.UP -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        findNavController().navigate(R.id.nav_home)
    }
}