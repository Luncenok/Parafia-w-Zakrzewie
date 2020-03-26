package pl.godziszewo.kosciol.database

import androidx.lifecycle.LiveData

class GalleryInfoRepository(private val galleryInfoDao: GalleryInfoDao) {
    val allGalleryInfo: LiveData<List<GalleryInfo>> = galleryInfoDao.getAll()

    suspend fun insert(galleryInfo: GalleryInfo) {
        galleryInfoDao.insert(galleryInfo)
    }

    suspend fun deleteAll() {
        galleryInfoDao.deleteAll()
    }
}