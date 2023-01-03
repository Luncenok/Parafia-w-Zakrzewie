/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:34 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.databinding.InfoFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.presentation.viewmodel.InfoViewModel

@AndroidEntryPoint
class InfoFragment : BaseFragment<InfoFragmentBinding, InfoViewModel>() {

    override val viewModel: InfoViewModel by viewModels()

    override fun getViewBinding(): InfoFragmentBinding = InfoFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    }

}
