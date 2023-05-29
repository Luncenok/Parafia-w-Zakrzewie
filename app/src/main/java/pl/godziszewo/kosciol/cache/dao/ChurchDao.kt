/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:18 PM
 *
 */

package pl.godziszewo.kosciol.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.cache.models.NewsCacheEntity

@Dao
interface ChurchDao {
    @Query("SELECT * FROM announcements")
    fun getAllAnnouncements(): List<AnnouncementCacheEntity>

    @Query("SELECT * FROM news")
    fun getAllNews(): List<NewsCacheEntity>

    @Query("DELETE FROM announcements")
    fun clearAnnouncements(): Int

    @Query("DELETE FROM news")
    fun clearNews(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAnnouncement(vararg announcementCacheEntity: AnnouncementCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(vararg newsCacheEntity: NewsCacheEntity)
}