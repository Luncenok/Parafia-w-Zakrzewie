/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:39 PM
 *
 */

package pl.godziszewo.kosciol.cache.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import pl.godziszewo.kosciol.R
import javax.inject.Inject

open class CachePreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_PACKAGE_NAME = "pl.godziszewo.kosciol.cache.preferences"
        private const val PREF_KEY_LAST_CACHE = "last_cache"
        private const val PREF_KEY_FiRST_APP_USE = "first_app_use"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var lastCacheTime: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

    var isFirstUse: Boolean
        get() = preferences.getBoolean(PREF_KEY_FiRST_APP_USE, true)
        set(firstUse) = preferences.edit().putBoolean(PREF_KEY_FiRST_APP_USE, firstUse).apply()
}