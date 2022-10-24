/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.godziszewo.kosciol.data.model.GalleryInfo

@Dao
interface GalleryInfoDao {
    @Query("SELECT * FROM gallery")
    fun getAll(): LiveData<List<GalleryInfo>>

    @Insert
    suspend fun insert(galleryInfo: GalleryInfo)

    @Query("DELETE FROM gallery")
    suspend fun deleteAll()
}
