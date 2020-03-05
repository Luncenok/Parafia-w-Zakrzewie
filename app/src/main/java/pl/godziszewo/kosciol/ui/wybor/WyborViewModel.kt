package pl.godziszewo.kosciol.ui.wybor

import android.app.Application
import android.text.Html
import android.text.Spanned
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import pl.godziszewo.kosciol.database.AppDatabase
import pl.godziszewo.kosciol.database.Biblia
import pl.godziszewo.kosciol.database.BibliaRepository
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
