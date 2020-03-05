package com.idziejczak.kosciol.ui.wybor

import android.app.Application
import android.content.Context
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.idziejczak.kosciol.database.AppDatabase
import com.idziejczak.kosciol.database.Biblia
import com.idziejczak.kosciol.database.BibliaRepository
import kotlinx.android.synthetic.main.wybor_fragment.*
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import timber.log.Timber
import java.net.UnknownHostException

class WyborViewModel(application: Application) : AndroidViewModel(application) {
    // dzieje się
    private val repository: BibliaRepository
    val allBiblia: LiveData<List<Biblia>>
    val allSpanstr: LiveData<List<Biblia>>
    var listaLinkow: ArrayList<String>
    var listaContentu: ArrayList<String>

    init {
        val bibliaDao = AppDatabase.getDatabase(application, viewModelScope).bibliaDao()
        repository = BibliaRepository(bibliaDao)
        allBiblia = repository.allBiblia
        allSpanstr = repository.allBibliaPoSpanstr
        listaLinkow = ArrayList()
        listaContentu = ArrayList()
    }


    fun naSpanned(html: String?): Spanned {
        return Html.fromHtml(html)
    }

    fun inser(biblia: Biblia) = viewModelScope.launch {
        repository.inser(biblia)
    }

    fun delall() = viewModelScope.launch {
        repository.delall()
    }

    fun delHome() = viewModelScope.launch {
        repository.delHome()
    }
}
