/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:50 PM
 *
 */

package pl.godziszewo.kosciol.cache.utils

import androidx.room.migration.Migration

class Migrations {
    companion object {
        const val DB_VERSION = 11

        fun getMigrations(): Array<Migration> {
            return arrayOf(
//                Migration(1, 2) {
//                    it.execSQL("ALTER TABLE announcements ADD COLUMN timestamp INTEGER NOT NULL DEFAULT 0")
//                }
            )
        }
    }
}