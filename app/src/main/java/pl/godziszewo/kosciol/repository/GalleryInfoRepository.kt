/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.repository

import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.data.local.GalleryInfoDao
import pl.godziszewo.kosciol.data.model.GalleryInfo
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