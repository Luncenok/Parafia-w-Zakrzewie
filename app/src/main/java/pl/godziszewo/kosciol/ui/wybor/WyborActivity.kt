package pl.godziszewo.kosciol.ui.wybor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.godziszewo.kosciol.R

class WyborActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wybor_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WyborFragment.newInstance())
                .commitNow()
        }
    }

}
