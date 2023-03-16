/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.cache.models.ConfessionCacheEntity
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity
import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.cache.models.IntentionCacheEntity
import pl.godziszewo.kosciol.cache.models.MassesCacheEntity
import pl.godziszewo.kosciol.cache.models.NewsCacheEntity

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
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao
}