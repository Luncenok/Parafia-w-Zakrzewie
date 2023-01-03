/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:34 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.data.PreferencesRepository
import pl.godziszewo.kosciol.databinding.MainFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.presentation.viewmodel.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()
    override fun getViewBinding(): MainFragmentBinding = MainFragmentBinding.inflate(layoutInflater)

    @Inject
    lateinit var prefRepository: PreferencesRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val swipe = binding.homeSwipe

        viewModel.dwnldcontent(swipe)

        if (prefRepository.isFirstUse) {
            viewModel.dwnldcontent(swipe)
            prefRepository.isFirstUse = false
        }

        swipe.setOnRefreshListener {
            viewModel.dwnldcontent(swipe)
        }
    }
}
