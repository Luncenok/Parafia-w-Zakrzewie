/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.galleries

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.databinding.GalleriesFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.presentation.viewmodel.GalleriesViewModel
import timber.log.Timber

@AndroidEntryPoint
class GalleriesFragment : BaseFragment<GalleriesFragmentBinding, GalleriesViewModel>() {

    override fun getViewBinding(): GalleriesFragmentBinding =
        GalleriesFragmentBinding.inflate(layoutInflater)

    override val viewModel: GalleriesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.galleriesRecycler
        val galleriesRecyclerAdapter = context?.let { GalleriesRecyclerAdapter() }
        recyclerView.apply {
            adapter = galleriesRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.dwnldcontent()

        viewModel.allGalleryCacheEntity.observe(viewLifecycleOwner) {
            galleriesRecyclerAdapter?.setItems(it)
            Timber.e(it.toString())
        }
    }

}
