/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:18 PM
 *
 */

package pl.godziszewo.kosciol.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.cache.dao.GalleryDao
import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.cache.models.ConfessionCacheEntity
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity
import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.cache.models.IntentionCacheEntity
import pl.godziszewo.kosciol.cache.models.MassesCacheEntity
import pl.godziszewo.kosciol.cache.models.NewsCacheEntity
import pl.godziszewo.kosciol.cache.utils.CacheConstants
import pl.godziszewo.kosciol.cache.utils.Migrations
import javax.inject.Inject

@Database(
    entities = [
        AnnouncementCacheEntity::class,
        ConfessionCacheEntity::class,
        HistoryCacheEntity::class,
        IntentionCacheEntity::class,
        MassesCacheEntity::class,
        NewsCacheEntity::class,
        GalleryCacheEntity::class,
    ],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase @Inject constructor() : RoomDatabase() {

    abstract fun churchDao(): ChurchDao
    abstract fun galleryDao(): GalleryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}