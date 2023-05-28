package com.example.rootppermissionapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.navigation.fragment.findNavController
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

        binding.rootAccessButton.setOnClickListener{
//            Runtime.getRuntime().exec("su")
            gainRoot()


        }

    }

    fun gainRoot() {

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