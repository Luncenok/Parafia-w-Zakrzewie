/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 7:20 PM
 *
 */

package pl.godziszewo.kosciol.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.cache.models.CemeteryCacheEntity
import pl.godziszewo.kosciol.cache.models.ConfessionCacheEntity
import pl.godziszewo.kosciol.cache.models.ContactCacheEntity
import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.cache.models.IntentionCacheEntity
import pl.godziszewo.kosciol.cache.models.MassesCacheEntity
import pl.godziszewo.kosciol.cache.models.NewsCacheEntity
import pl.godziszewo.kosciol.cache.utils.CacheConstants
import pl.godziszewo.kosciol.cache.utils.Migrations

@Database(
    entities = [
        AnnouncementCacheEntity::class,
        ConfessionCacheEntity::class,
        HistoryCacheEntity::class,
        IntentionCacheEntity::class,
        MassesCacheEntity::class,
        NewsCacheEntity::class,
        CemeteryCacheEntity::class,
        ContactCacheEntity::class,
    ],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun churchDao(): ChurchDao

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
        ).fallbackToDestructiveMigration().build()
    }
}