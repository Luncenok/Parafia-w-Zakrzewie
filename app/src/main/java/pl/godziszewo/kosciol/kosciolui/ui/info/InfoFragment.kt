/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:03 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.databinding.InfoFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.kosciolui.extension.observe
import pl.godziszewo.kosciol.presentation.viewmodel.InfoUIModel
import pl.godziszewo.kosciol.presentation.viewmodel.InfoViewModel
import javax.inject.Inject

@AndroidEntryPoint
class InfoFragment : BaseFragment<InfoFragmentBinding, InfoViewModel>() {

    override val viewModel: InfoViewModel by viewModels()
    private val args: InfoFragmentArgs by navArgs()

    override fun getViewBinding(): InfoFragmentBinding = InfoFragmentBinding.inflate(layoutInflater)

    @Inject
    lateinit var infoAdapter: InfoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getInfo(args.infoType)
        observe(viewModel.getInfo(), ::onViewStateChange)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.infoRecycler.apply {
            adapter = infoAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onViewStateChange(event: InfoUIModel) {
        if (event.isRedelivered) return
        when (event) {
            is InfoUIModel.Error -> handleErrorMessage(event.error)
            is InfoUIModel.Loading -> handleLoading(true)
            is InfoUIModel.Success -> {
                handleLoading(false)
                event.data.let {
                    infoAdapter.list = it
                }
            }
        }
    }

}
