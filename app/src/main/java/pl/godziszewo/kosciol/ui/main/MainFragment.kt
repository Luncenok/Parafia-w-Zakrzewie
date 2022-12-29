/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/29/22, 3:23 PM
 *
 */

package pl.godziszewo.kosciol.ui.main

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
import pl.godziszewo.kosciol.repository.PreferencesRepository
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainFragmentBinding

    @Inject
    lateinit var prefRepository: PreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        val swipe = binding.homeSwipe

        viewModel.dwnldcontent(swipe)

        if (prefRepository.isFirstUse) {
            viewModel.dwnldcontent(swipe)
            prefRepository.isFirstUse = false
        }

        swipe.setOnRefreshListener {
            viewModel.dwnldcontent(swipe)
        }


        return binding.root
    }
}
