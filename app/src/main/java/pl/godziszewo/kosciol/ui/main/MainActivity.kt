package pl.godziszewo.kosciol.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.godziszewo.kosciol.BuildConfig
import pl.godziszewo.kosciol.R
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
