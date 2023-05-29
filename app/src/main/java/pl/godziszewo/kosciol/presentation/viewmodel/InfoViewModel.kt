/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:15 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(repository: BibliaRepository) : ViewModel() {
    val allBiblia: LiveData<List<Biblia>>
    val allSpanstr: LiveData<List<Biblia>>
    var listaLinkow: ArrayList<String>
    var listaContentu: ArrayList<String>

    init {
        allBiblia = repository.allBiblia
        allSpanstr = repository.allBibliaPoSpanstr
        listaLinkow = ArrayList()
        listaContentu = ArrayList()
    }


    fun naSpanned(html: String?): Spanned {
        @Suppress("DEPRECATION")
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(html)
    }
}
