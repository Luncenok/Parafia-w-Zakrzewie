/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:18 PM
 *
 */

package pl.godziszewo.kosciol.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity

@Dao
interface GalleryDao {
    @Query("SELECT * FROM gallery")
    fun getAll(): List<GalleryCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(galleryCacheEntity: GalleryCacheEntity)

    @Query("DELETE FROM gallery")
    suspend fun deleteAll()
}
