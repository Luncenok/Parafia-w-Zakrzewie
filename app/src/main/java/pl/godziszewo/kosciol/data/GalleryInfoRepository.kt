/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:09 PM
 *
 */

package pl.godziszewo.kosciol.data

import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.cache.GalleryInfoDao
import pl.godziszewo.kosciol.cache.models.GalleryInfo
import javax.inject.Inject

class GalleryInfoRepository @Inject constructor(private val galleryInfoDao: GalleryInfoDao) {
    val allGalleryInfo: LiveData<List<GalleryInfo>> = galleryInfoDao.getAll()

    suspend fun insert(galleryInfo: GalleryInfo) {
        galleryInfoDao.insert(galleryInfo)
    }

    suspend fun deleteAll() {
        galleryInfoDao.deleteAll()
    }
}