package pl.godziszewo.kosciol.repository

import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.data.local.GalleryInfoDao
import pl.godziszewo.kosciol.data.model.GalleryInfo

class GalleryInfoRepository(private val galleryInfoDao: GalleryInfoDao) {
    val allGalleryInfo: LiveData<List<GalleryInfo>> = galleryInfoDao.getAll()

    suspend fun insert(galleryInfo: GalleryInfo) {
        galleryInfoDao.insert(galleryInfo)
    }

    suspend fun deleteAll() {
        galleryInfoDao.deleteAll()
    }
}