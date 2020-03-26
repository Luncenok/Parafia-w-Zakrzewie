package pl.godziszewo.kosciol.ui.galleries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.godziszewo.kosciol.R

class GalleriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.galleries_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GalleriesFragment.newInstance())
                .commitNow()
        }
    }
}
