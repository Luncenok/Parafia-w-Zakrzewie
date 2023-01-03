/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.cache.models.Biblia
import pl.godziszewo.kosciol.cache.models.GalleryInfo

@Database(
    entities = [Biblia::class, GalleryInfo::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao
}