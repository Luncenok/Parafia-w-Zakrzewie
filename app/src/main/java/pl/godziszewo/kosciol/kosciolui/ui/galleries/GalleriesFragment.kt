/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:01 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.galleries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.databinding.GalleriesFragmentBinding
import pl.godziszewo.kosciol.presentation.viewmodel.GalleriesViewModel
import timber.log.Timber

@AndroidEntryPoint
class GalleriesFragment : Fragment() {

    private val viewModel: GalleriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: GalleriesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.galleries_fragment, container, false)

        val recyclerView: RecyclerView = binding.galleriesRecycler
        val galleriesRecyclerAdapter = context?.let { GalleriesRecyclerAdapter() }
        recyclerView.apply {
            adapter = galleriesRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.dwnldcontent()

        viewModel.allGalleryInfo.observe(viewLifecycleOwner) {
            galleriesRecyclerAdapter?.setItems(it)
            Timber.e(it.toString())
        }

        return binding.root
    }

}
