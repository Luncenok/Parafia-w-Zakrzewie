package pl.godziszewo.kosciol.ui.info

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.data.local.AppDatabase
import pl.godziszewo.kosciol.data.model.Biblia
import pl.godziszewo.kosciol.repository.BibliaRepository

class InfoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BibliaRepository
    val allBiblia: LiveData<List<Biblia>>
    val allSpanstr: LiveData<List<Biblia>>
    var listaLinkow: ArrayList<String>
    var listaContentu: ArrayList<String>

    init {
        val bibliaDao = AppDatabase.getInstance(application).bibliaDao()
        repository = BibliaRepository(bibliaDao)
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
