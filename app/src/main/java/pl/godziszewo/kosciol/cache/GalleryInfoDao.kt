/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.godziszewo.kosciol.cache.models.GalleryInfo

@Dao
interface GalleryInfoDao {
    @Query("SELECT * FROM gallery")
    fun getAll(): LiveData<List<GalleryInfo>>

    @Insert
    suspend fun insert(galleryInfo: GalleryInfo)

    @Query("DELETE FROM gallery")
    suspend fun deleteAll()
}
