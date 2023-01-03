/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *  
 */

package pl.godziszewo.kosciol.kosciolui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import pl.godziszewo.kosciol.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class KosciolApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}