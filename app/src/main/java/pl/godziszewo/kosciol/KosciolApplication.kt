package pl.godziszewo.kosciol

import android.app.Application
import timber.log.Timber

class KosciolApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}