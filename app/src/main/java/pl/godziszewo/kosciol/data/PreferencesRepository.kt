/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import pl.godziszewo.kosciol.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesRepository @Inject constructor(
    @ApplicationContext val context: Context,
    private val sharedPref: SharedPreferences
) {
    var isFirstUse: Boolean
        get() = sharedPref.getBoolean(context.getString(R.string.first_app_use), true)
        set(value) = sharedPref.edit {
            putBoolean(
                context.getString(R.string.first_app_use),
                value
            )
        }
}