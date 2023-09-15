/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 7:20 PM
 *
 */

package pl.godziszewo.kosciol.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.cache.models.CemeteryCacheEntity
import pl.godziszewo.kosciol.cache.models.ConfessionCacheEntity
import pl.godziszewo.kosciol.cache.models.ContactCacheEntity
import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.cache.models.IntentionCacheEntity
import pl.godziszewo.kosciol.cache.models.MassesCacheEntity
import pl.godziszewo.kosciol.cache.models.NewsCacheEntity

@Dao
interface ChurchDao {

    @Query("SELECT * FROM news")
    fun getAllNews(): List<NewsCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(vararg newsCacheEntity: NewsCacheEntity)

    @Query("SELECT * FROM history")
    fun getHistory(): HistoryCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(historyCacheEntity: HistoryCacheEntity)

    @Query("SELECT * FROM masses")
    fun getMasses(): MassesCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMasses(massesCacheEntity: MassesCacheEntity)

    @Query("SELECT * FROM confessions")
    fun getConfessions(): ConfessionCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addConfessions(confessionCacheEntity: ConfessionCacheEntity)

    @Query("SELECT * FROM intentions")
    fun getAllIntentions(): List<IntentionCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIntention(vararg intentionCacheEntity: IntentionCacheEntity)

    @Query("SELECT * FROM announcements")
    fun getAllAnnouncements(): List<AnnouncementCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAnnouncement(vararg announcementCacheEntity: AnnouncementCacheEntity)

    @Query("SELECT * FROM cemetery")
    fun getCemetery(): CemeteryCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCemetery(cemeteryCacheEntity: CemeteryCacheEntity)

    @Query("SELECT * FROM contact")
    fun getContact(): ContactCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContact(contactCacheEntity: ContactCacheEntity)
}