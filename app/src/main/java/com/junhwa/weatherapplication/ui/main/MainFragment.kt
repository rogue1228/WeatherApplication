package com.junhwa.weatherapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.junhwa.weatherapplication.R
import com.junhwa.weatherapplication.databinding.MainFragmentBinding
import org.koin.android.viewmodel.ext.android.getSharedViewModel

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by lazy { getSharedViewModel() }

    private val adapter: WeatherAdapter by lazy { WeatherAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.dataBinder = viewModel
        initViews()
        initViewModel()
    }

    private fun initViews() {
        binding.weatherRecyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadData()
            adapter.clear()
        }

    }

    private fun initViewModel() {
        viewModel.weatherData.observe(viewLifecycleOwner) {
            adapter.addItems(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.swipeRefreshLayout.isRefreshing = it
        }

        viewModel.loadData()
    }
}