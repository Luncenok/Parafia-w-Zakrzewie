/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:15 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import android.net.TrafficStats
import android.text.SpannableStringBuilder
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: BibliaRepository) : ViewModel() {
    val allBiblia: LiveData<List<Biblia>> = repository.allBiblia
    val allBibliaPoRozdziale: LiveData<List<Biblia>> = repository.allBibliaPoRozdziale

    fun dwnldcontent(refreshLayout: SwipeRefreshLayout) {
        refreshLayout.isRefreshing = true
        dwnldAktualnosci(refreshLayout)
        dwnldIntencje()
        dwnldOgloszenia()
        dwnldHistoria()
        dwnldPatron()
        dwnldCmentarz()
        dwnldSakramenty()
        dwnldKontakt(refreshLayout)
    }

    private fun dwnldAktualnosci(refreshLayout: SwipeRefreshLayout) {
        Timber.i("Aktualnosci sa pobierane")
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                val listaLinkow = ArrayList<String>()
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10001)
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun dwnldIntencje() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Intencje sa pobierane")
                val listaLinkow = ArrayList<String>()
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10002)
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun dwnldOgloszenia() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Ogloszenia sa pobierane")
                val listaLinkow = ArrayList<String>()
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10003)
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun dwnldHistoria() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Historia sa pobierane")
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10004)
                val doc = Jsoup.connect("$url/historia_parafii").get().body()
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun dwnldPatron() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Patron sa pobierane")
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10005)
                val doc = Jsoup.connect("$url/nasz_patron").get().body()
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun dwnldCmentarz() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Cmentarz sa pobierane")
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10006)
                val doc = Jsoup.connect("$url/cmentarz").get().body()
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }

    private fun dwnldKontakt(refreshLayout: SwipeRefreshLayout) {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Kontakt sa pobierane")
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10007)
                val doc = Jsoup.connect("$url/kontakt").get().body()
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
            } catch (e: UnknownHostException) {
                Snackbar.make(refreshLayout, "Brak internetu", Snackbar.LENGTH_LONG).show()
                refreshLayout.isRefreshing = false
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }

    private fun dwnldSakramenty() {
        val url = "https://kazimierz.archpoznan.pl"
        Thread {
            try {
                Timber.i("Sakramenty sa pobierane")
                val listaContentu = ArrayList<String>()
                TrafficStats.setThreadStatsTag(10008)
                val doc = Jsoup.connect("$url/sakramenty").get().body()
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
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }

    private fun inser(biblia: Biblia) = viewModelScope.launch {
        repository.inser(biblia)
    }

    private fun delSpanstrAkt() = viewModelScope.launch {
        repository.delSpanstrAkt()
    }

    private fun delSpanstrCmt() = viewModelScope.launch {
        repository.delSpanstrCmt()
    }

    private fun delSpanstrHis() = viewModelScope.launch {
        repository.delSpanstrHis()
    }

    private fun delSpanstrInt() = viewModelScope.launch {
        repository.delSpanstrInt()
    }

    private fun delSpanstrOgl() = viewModelScope.launch {
        repository.delSpanstrOgl()
    }

    private fun delSpanstrPat() = viewModelScope.launch {
        repository.delSpanstrPat()
    }

    private fun delSpanstrSak() = viewModelScope.launch {
        repository.delSpanstrSak()
    }

    private fun delSpanstrKon() = viewModelScope.launch {
        repository.delSpanstrKon()
    }

}
