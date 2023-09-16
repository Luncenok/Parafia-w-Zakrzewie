/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/16/23, 5:15 PM
 *
 */

package pl.godziszewo.kosciol.cache.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

open class CachePreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_PACKAGE_NAME = "pl.godziszewo.kosciol.cache.preferences"
        private const val PREF_KEY_LAST_CACHE_News = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Announcements = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Intentions = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Cemetery = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Contact = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Confession = "last_cache"
        private const val PREF_KEY_LAST_CACHE_History = "last_cache"
        private const val PREF_KEY_LAST_CACHE_Masses = "last_cache"
        private const val PREF_KEY_FiRST_APP_USE = "first_app_use"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var lastCacheTimeNews: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_News, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_News, lastCache).apply()

    var lastCacheTimeAnnouncements: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Announcements, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Announcements, lastCache)
            .apply()

    var lastCacheTimeIntentions: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Intentions, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Intentions, lastCache)
            .apply()

    var lastCacheTimeCemetery: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Cemetery, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Cemetery, lastCache).apply()

    var lastCacheTimeContact: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Contact, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Contact, lastCache).apply()

    var lastCacheTimeConfession: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Confession, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Confession, lastCache)
            .apply()

    var lastCacheTimeHistory: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_History, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_History, lastCache).apply()

    var lastCacheTimeMasses: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE_Masses, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE_Masses, lastCache).apply()

    var isFirstUse: Boolean
        get() = preferences.getBoolean(PREF_KEY_FiRST_APP_USE, true)
        set(firstUse) = preferences.edit().putBoolean(PREF_KEY_FiRST_APP_USE, firstUse).apply()
}