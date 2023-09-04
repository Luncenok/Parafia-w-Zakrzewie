/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:32 PM
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

}
