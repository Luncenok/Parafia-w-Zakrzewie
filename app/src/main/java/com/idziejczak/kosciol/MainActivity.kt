package com.idziejczak.kosciol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idziejczak.kosciol.ui.main.MainFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        if (BuildConfig.DEBUG) {
            Timber.plant( Timber.DebugTree())
        }


    }

}
