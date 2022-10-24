/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.data.model.Biblia
import pl.godziszewo.kosciol.data.model.GalleryInfo

@Database(
    entities = [Biblia::class, GalleryInfo::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao
}