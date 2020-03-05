package com.idziejczak.kosciol.ui.main

import android.app.Application
import android.content.Context
import android.text.SpannableStringBuilder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.idziejczak.kosciol.database.AppDatabase
import com.idziejczak.kosciol.database.Biblia
import com.idziejczak.kosciol.database.BibliaRepository
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import timber.log.Timber
import java.net.UnknownHostException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BibliaRepository
    val allBiblia: LiveData<List<Biblia>>
    val allBibliaPoRozdziale: LiveData<List<Biblia>>

    init {
        val bibliaDao = AppDatabase.getDatabase(application, viewModelScope).bibliaDao()
        repository = BibliaRepository(bibliaDao)
        allBiblia = repository.allBiblia
        allBibliaPoRozdziale = repository.allBibliaPoRozdziale
    }

    fun dwnldcontent(context: Context?, refreshLayout: SwipeRefreshLayout) {
        dwnldAktualnosci(refreshLayout)
        dwnldIntencje()
        dwnldOgloszenia()
        dwnldHistoria()
        dwnldPatron()
        dwnldCmentarz()
        dwnldSakramenty()
        dwnldKontakt()
    }

    fun dwnldAktualnosci(refreshLayout: SwipeRefreshLayout) {
        Timber.i("Aktualnosci sa pobierane")
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            val listaLinkow = ArrayList<String>()
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/aktualnosci").get().body()
            var content: String
            doc.select("h3 a:not(page-link)").forEach { elem ->
                listaLinkow.add(elem.attr("href"))
            }
            listaLinkow.forEach { link ->
                val docum = Jsoup.connect(url + link).get()
                content =
                    docum.select(".content").toString()
                        .replace(
                            "« wstecz",
                            ""
                        ).replace(
                            "drukuj",
                            ""
                        ).replace(
                            "«",
                            ""
                        )
                listaContentu.add(content)
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrAkt()
            val biblia = Biblia(0, "Aktualności", "spanstr", spanstr.toString())
            inser(biblia)
            refreshLayout.isRefreshing = false
            Timber.i("Aktualnosci koniec")
        }).start()
    }

    fun dwnldIntencje() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Intencje sa pobierane")
            val listaLinkow = ArrayList<String>()
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/intencje").get().body()
            var content: String
            doc.select(".content a:not(.page-link)").forEach { elem ->
                listaLinkow.add(elem.attr("href"))
            }
            listaLinkow.forEach { link ->
                val docum = Jsoup.connect(url + link).get()
                content =
                    docum.select(".content").toString()
                        .replace(
                            "« wstecz",
                            ""
                        ).replace(
                            "drukuj",
                            ""
                        ).replace(
                            "«",
                            ""
                        )
                listaContentu.add(content)
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrInt()
            val biblia = Biblia(0, "Intencje", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Intencje koniec")
        }).start()
    }

    fun dwnldOgloszenia() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Ogloszenia sa pobierane")
            val listaLinkow = ArrayList<String>()
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/ogloszenia_duszpasterskie").get().body()
            var content: String
            doc.select(".content a:not(.page-link)").forEach { elem ->
                listaLinkow.add(elem.attr("href"))
            }
            listaLinkow.forEach { link ->
                val docum = Jsoup.connect(url + link).get()
                content =
                    docum.select(".content").toString()
                        .replace(
                            "« wstecz",
                            ""
                        ).replace(
                            "drukuj",
                            ""
                        ).replace(
                            "«",
                            ""
                        )
                listaContentu.add(content)
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrOgl()
            val biblia = Biblia(0, "Ogłoszenia", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Ogloszenia koniec")
        }).start()
    }

    fun dwnldHistoria() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Historia sa pobierane")
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/historia_parafii").get().body()
            var content: String
            doc.select(".content").forEach { elem ->
                listaContentu.add(elem.toString())
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrHis()
            val biblia = Biblia(0, "Historia parafii", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Historia koniec")
        }).start()
    }

    fun dwnldPatron() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Patron sa pobierane")
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/nasz_patron").get().body()
            var content: String
            doc.select(".content").forEach { elem ->
                listaContentu.add(elem.toString())
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrPat()
            val biblia = Biblia(0, "Nasz patron", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Patron koniec")
        }).start()
    }

    fun dwnldCmentarz() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Cmentarz sa pobierane")
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/cmentarz").get().body()
            var content: String
            doc.select(".content").forEach { elem ->
                listaContentu.add(elem.toString())
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrCmt()
            val biblia = Biblia(0, "Cmentarz", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Cmentarz koniec")
        }).start()

    }

    fun dwnldKontakt() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Kontakt sa pobierane")
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/kontakt").get().body()
            var content: String
            doc.select(".col-sm-5").forEach { elem ->
                listaContentu.add(elem.toString())
            }
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrKon()
            val biblia = Biblia(0, "Kontakt", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Kontakt koniec")
        }).start()

    }

    fun dwnldSakramenty() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread(Runnable {
            Timber.i("Sakramenty sa pobierane")
            val listaContentu = ArrayList<String>()
            val doc = Jsoup.connect("$url/sakramenty").get().body()
            var content: String
            listaContentu.add(doc.select(".sacraments #sacrament1").toString())
            listaContentu.add(doc.select(".sacraments #sacrament2").toString())
            listaContentu.add(doc.select(".sacraments #sacrament3").toString())
            listaContentu.add(doc.select(".sacraments #sacrament4").toString())
            listaContentu.add(doc.select(".sacraments #sacrament5").toString())
            listaContentu.add(doc.select(".sacraments #sacrament6").toString())
            listaContentu.add(doc.select(".sacraments #sacrament7").toString())
            listaContentu.add(doc.select(".sacraments #sacrament8").toString())
            listaContentu.add(doc.select(".sacraments #sacrament9").toString())
            val spanstr = SpannableStringBuilder()
            listaContentu.forEach {
                spanstr.append(it)
            }
            delSpanstrSak()
            val biblia = Biblia(0, "Sakramenty", "spanstr", spanstr.toString())
            inser(biblia)
            Timber.i("Sakramenty koniec")
        }).start()

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

    fun delSpanstrAkt() = viewModelScope.launch {
        repository.delSpanstrAkt()
    }

    fun delSpanstrCmt() = viewModelScope.launch {
        repository.delSpanstrCmt()
    }

    fun delSpanstrHis() = viewModelScope.launch {
        repository.delSpanstrHis()
    }

    fun delSpanstrInt() = viewModelScope.launch {
        repository.delSpanstrInt()
    }

    fun delSpanstrOgl() = viewModelScope.launch {
        repository.delSpanstrOgl()
    }

    fun delSpanstrPat() = viewModelScope.launch {
        repository.delSpanstrPat()
    }

    fun delSpanstrSak() = viewModelScope.launch {
        repository.delSpanstrSak()
    }

    fun delSpanstrKon() = viewModelScope.launch {
        repository.delSpanstrKon()
    }

}
