package com.example.rootppermissionapp

import android.content.Context
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rootppermissionapp.databinding.FragmentFirstBinding
import java.io.IOException


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rootAccessButton.setOnClickListener {
            checkForRootAccess()
        }
        binding.devOpCheck.setOnClickListener {
            checkForDevOptions()
        }
    }

    private fun checkForDevOptions() {
        val devOptionsEnabled = Settings.Secure.getInt(
            requireContext().contentResolver,
            Settings.Global.ADB_ENABLED,
            0
        ) != 0
        when (devOptionsEnabled) {
            true -> showToast(requireContext(), "Developer options are on")
            false -> showToast(requireContext(), "Developer options are off")
        }
    }

    private fun checkForRootAccess() {
        try {
            Runtime.getRuntime().exec("su")
            showToast(requireContext(), "This Device is has Root Access")
        } catch (e: IOException) {
            showToast(requireContext(), "This Device is doesn't have Root Access")
        }
    }

    private fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }
}