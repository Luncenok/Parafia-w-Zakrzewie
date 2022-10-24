/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.databinding.MainFragmentBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        val swipe = binding.mainSwipe
//        val odswiezBtn = binding.mainBtnRefresh

        viewModel.dwnldcontent(swipe)

        if (sharedPref!!.getBoolean(getString(R.string.first_app_use), true)) {
            viewModel.dwnldcontent(swipe)
            sharedPref.edit().putBoolean(getString(R.string.first_app_use), false).apply()
        }

        swipe.setOnRefreshListener {
            viewModel.dwnldcontent(swipe)
        }
//        odswiezBtn.setOnClickListener {
//            swipe.isRefreshing = true
//            viewModel.dwnldcontent(swipe)
//        }


        return binding.root
    }
}
