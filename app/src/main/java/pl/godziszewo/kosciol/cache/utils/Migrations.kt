/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:25 PM
 *
 */

package pl.godziszewo.kosciol.cache.utils

import androidx.room.migration.Migration

class Migrations {
    companion object {
        const val DB_VERSION = 1

        fun getMigrations(): Array<Migration> {
            return arrayOf(
//                Migration(1, 2) {
//                    it.execSQL("ALTER TABLE announcements ADD COLUMN timestamp INTEGER NOT NULL DEFAULT 0")
//                }
            )
        }
    }
}