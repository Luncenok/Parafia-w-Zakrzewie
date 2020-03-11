package pl.godziszewo.kosciol.ui.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.godziszewo.kosciol.R

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GalleryFragment.newInstance())
                .commitNow()
        }
    }
}
