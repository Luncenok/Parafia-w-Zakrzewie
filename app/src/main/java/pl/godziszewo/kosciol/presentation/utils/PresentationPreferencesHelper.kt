/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:31 PM
 *
 */

package pl.godziszewo.kosciol.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

open class PresentationPreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_PACKAGE_NAME = "pl.godziszewo.kosciol.presentation.preferences"
        private const val PREF_KEY_FIRST_USE = "first_use"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var isFirstUse: Boolean
        get() = preferences.getBoolean(PREF_KEY_FIRST_USE, true)
        set(isDarkMode) = preferences.edit().putBoolean(PREF_KEY_FIRST_USE, isDarkMode).apply()
}
