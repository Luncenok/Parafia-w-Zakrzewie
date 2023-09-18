/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 4:08 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.godziszewo.kosciol.databinding.HomeFragmentBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseFragment
import pl.godziszewo.kosciol.presentation.viewmodel.HomeViewModel


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getViewBinding(): HomeFragmentBinding = HomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeCardNews.setOnClickListener {
            //findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("NEWS"))
            val url = "https://www.facebook.com/kazimierz.zakrzewo"
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }
        binding.homeCardAnnouncements.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("ANNOUNCEMENTS"))
        }
        binding.homeCardCemetery.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("CEMETERY"))
        }
        binding.homeCardConfession.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("CONFESSION"))
        }
        binding.homeCardContact.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("CONTACT"))
        }
        binding.homeCardHistory.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("HISTORY"))
        }
        binding.homeCardIntentions.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("INTENTIONS"))
        }
        binding.homeCardMasses.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionToInfoFragment("MASSES"))
        }
    }

}
