/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.databinding.InfoFragmentBinding

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val viewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: InfoFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.info_fragment, container, false)

        val kategoria = activity?.intent?.getStringExtra("kategoria")
        activity?.title = if (kategoria == "Historia parafii") "Parafia" else kategoria
        var dod = ""
        viewModel.allSpanstr.observe(viewLifecycleOwner) {
            it.forEach { biblia ->
                if (kategoria == "Historia parafii") {
                    if (biblia.ksiega == kategoria || biblia.ksiega == "Cmentarz" || biblia.ksiega == "Nasz patron")
                        dod += biblia.werset
                    binding.infoText.text = viewModel.naSpanned(dod)
                } else if (biblia.ksiega == kategoria) {
                    binding.infoText.text = viewModel.naSpanned(biblia.werset)
                }
            }

        }
        return binding.root
    }

}
