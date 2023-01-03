/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 10:04 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import pl.godziszewo.kosciol.cache.models.GalleryInfo
import pl.godziszewo.kosciol.data.GalleryInfoRepository
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class GalleriesViewModel @Inject constructor(private val repository: GalleryInfoRepository) : ViewModel() {

    val allGalleryInfo: LiveData<List<GalleryInfo>> = repository.allGalleryInfo

    fun dwnldcontent() {
        Timber.i("GalleryInfo sa pobierane")
        val url = "https://kazimierz.archpoznan.pl/galeria_zdjec"
        Thread {
            try {
                val doc = Jsoup.connect(url).get().body()
                deleteAll()
                doc.select(".thumbnail").forEach { elem ->
                    Timber.i("Gallery sa pobierane")
                    var list = ""
                    try {
                        val doc1 =
                            Jsoup.connect("https://kazimierz.archpoznan.pl" + elem.attr("href"))
                                .get().body()
                        doc1.select(".thumbnail>a").forEach { elemen ->
                            list += "https://kazimierz.archpoznan.pl" + elemen.attr("href") + ","
                            Timber.e("""https://kazimierz.archpoznan.pl${elemen.attr("src")}""")
                        }
                        list = list.dropLast(1)
                        Timber.i("gallery koniec")
                    } catch (e: UnknownHostException) {
                        Timber.i("Brak internetu")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    val galleryInfo = GalleryInfo(
                        0,
                        "https://kazimierz.archpoznan.pl" + elem.select("img").attr("src"),
                        "https://kazimierz.archpoznan.pl" + elem.attr("href"),
                        list,
                        elem.text().substring(0, elem.text().length - 11),
                        elem.text().substring(elem.text().length - 10, elem.text().length)
                    )
                    insert(galleryInfo)
                }
                Timber.i("galleryinfo koniec")
            } catch (e: UnknownHostException) {
                Timber.i("Brak internetu")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun insert(galleryInfo: GalleryInfo) = viewModelScope.launch {
        repository.insert(galleryInfo)
    }

    private fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}
