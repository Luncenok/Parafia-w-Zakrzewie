/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity

@Dao
interface GalleryInfoDao {
    @Query("SELECT * FROM gallery")
    fun getAll(): LiveData<List<GalleryCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(galleryCacheEntity: GalleryCacheEntity)

    @Query("DELETE FROM gallery")
    suspend fun deleteAll()
}
