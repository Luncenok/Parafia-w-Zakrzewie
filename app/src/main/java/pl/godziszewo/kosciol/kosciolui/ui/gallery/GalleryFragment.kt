/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:01 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.databinding.GalleriesFragmentBinding
import pl.godziszewo.kosciol.presentation.viewmodel.GalleryViewModel
import timber.log.Timber

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: GalleriesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.gallery_fragment, container, false)
        val galleryRecyclerAdapter = GalleryRecyclerAdapter(requireContext())

        val link = activity?.intent?.getIntExtra("link", 0)
        viewModel.allGalleryInfo.observe(viewLifecycleOwner) { list ->
            list.forEach { gi ->
                if (gi.id == link) {
                    val linki = gi.linki.split(",")
                    galleryRecyclerAdapter.setItems(linki)
                    Timber.e("ustawniono")
                }
            }
        }

        binding.galleriesRecycler.apply {
            adapter = galleryRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

}
