package pl.godziszewo.kosciol.ui.gallery

import android.app.Application
import androidx.lifecycle.*
import org.jsoup.Jsoup
import pl.godziszewo.kosciol.database.AppDatabase
import pl.godziszewo.kosciol.database.GalleryInfo
import pl.godziszewo.kosciol.database.GalleryInfoRepository
import timber.log.Timber
import java.net.UnknownHostException

class GalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GalleryInfoRepository
    val allGalleryInfo: LiveData<List<GalleryInfo>>

    init {
        val galleryInfoDao = AppDatabase.getDatabase(application, viewModelScope).galleryInfoDao()
        repository = GalleryInfoRepository(galleryInfoDao)
        allGalleryInfo = repository.allGalleryInfo
    }

}
