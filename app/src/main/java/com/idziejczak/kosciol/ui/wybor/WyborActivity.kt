package com.idziejczak.kosciol.ui.wybor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idziejczak.kosciol.R

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
