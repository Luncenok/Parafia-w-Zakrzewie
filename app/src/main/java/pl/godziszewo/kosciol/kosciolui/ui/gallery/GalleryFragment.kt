/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:34 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.databinding.GalleryFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.presentation.viewmodel.GalleryViewModel
import timber.log.Timber

@AndroidEntryPoint
class GalleryFragment : BaseFragment<GalleryFragmentBinding, GalleryViewModel>() {

    override val viewModel: GalleryViewModel by viewModels()

    override fun getViewBinding(): GalleryFragmentBinding =
        GalleryFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

        binding.galleryRecycler.apply {
            adapter = galleryRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}
