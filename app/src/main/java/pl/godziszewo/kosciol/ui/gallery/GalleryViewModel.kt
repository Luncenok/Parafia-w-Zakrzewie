package pl.godziszewo.kosciol.ui.gallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import pl.godziszewo.kosciol.data.local.AppDatabase
import pl.godziszewo.kosciol.data.model.GalleryInfo
import pl.godziszewo.kosciol.repository.GalleryInfoRepository

class GalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GalleryInfoRepository
    val allGalleryInfo: LiveData<List<GalleryInfo>>

    init {
        val galleryInfoDao = AppDatabase.getDatabase(application, viewModelScope).galleryInfoDao()
        repository = GalleryInfoRepository(galleryInfoDao)
        allGalleryInfo = repository.allGalleryInfo
    }

}
