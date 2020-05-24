package pl.godziszewo.kosciol.ui.galleries

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import pl.godziszewo.kosciol.database.AppDatabase
import pl.godziszewo.kosciol.database.GalleryInfo
import pl.godziszewo.kosciol.database.GalleryInfoRepository
import timber.log.Timber
import java.net.UnknownHostException

class GalleriesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GalleryInfoRepository
    val allGalleryInfo: LiveData<List<GalleryInfo>>

    init {
        val galleryInfoDao = AppDatabase.getDatabase(application, viewModelScope).galleryInfoDao()
        repository = GalleryInfoRepository(galleryInfoDao)
        allGalleryInfo = repository.allGalleryInfo
    }

    fun dwnldcontent() {
        Timber.i("GalleryInfo sa pobierane")
        val url = "https://kazimierz.archpoznan.pl/galeria_zdjec"
        Thread(Runnable {
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
        }).start()
    }

    private fun insert(galleryInfo: GalleryInfo) = viewModelScope.launch {
        repository.insert(galleryInfo)
    }

    private fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}
