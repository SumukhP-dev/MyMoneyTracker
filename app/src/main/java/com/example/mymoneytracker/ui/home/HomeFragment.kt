package com.example.mymoneytracker.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mymoneytracker.R
import com.example.mymoneytracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var netWorth = -100

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.HistoryButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_historyFragment)
        }

        binding.SummaryButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_summaryFragment)
        }

        if(netWorth >= 0) {
            binding.NetWorthAmount.setTextColor(Color.parseColor("#00FF0A"))
            binding.NetWorthAmount.text = "$" + netWorth.toString()
        } else {
            binding.NetWorthAmount.setTextColor(Color.parseColor("#FF1100"))
            binding.NetWorthAmount.text = "($" + netWorth.toString() + ")"
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}