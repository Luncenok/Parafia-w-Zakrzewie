package pl.godziszewo.kosciol.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import pl.godziszewo.kosciol.R
import timber.log.Timber

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.e("OnCreateView created")
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        val swl: SwipeRefreshLayout = root.findViewById(R.id.swipe_refresh_layout)
        val odswiezBtn = root.findViewById<TextView>(R.id.odswiez_btn)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)
//        val homeAdapter = context?.let { HomeAdapter(it) }
//        recyclerView.adapter = homeAdapter
//        recyclerView.layoutManager = LinearLayoutManager(context)

//        viewModel.allBibliaPoRozdziale.observe(this, Observer { libiblia ->
//            libiblia.let { homeAdapter?.setLiBiblia(it) }
//        })
        viewModel.dwnldcontent(swl)

        if (sharedPref!!.getBoolean(getString(R.string.first_app_use), true)) {
            viewModel.dwnldcontent(swl)
            sharedPref.edit().putBoolean(getString(R.string.first_app_use), false).apply()
        }

        swl.setOnRefreshListener {
            viewModel.dwnldcontent(swl)
        }
        odswiezBtn.setOnClickListener {
            swl.isRefreshing = true
            viewModel.dwnldcontent(swl)
        }

        val intent = Intent(activity, InfoActivity::class.java)
        val ogloszeniaLayout = root.findViewById<LinearLayout>(R.id.ogloszenia_layout)
        val aktualnosciLayout = root.findViewById<LinearLayout>(R.id.aktualnosci_layout)
        val intencjeLayout = root.findViewById<LinearLayout>(R.id.intencje_layout)
        val parafiaLayout = root.findViewById<LinearLayout>(R.id.parafia_layout)
        val sakramentyLayout = root.findViewById<LinearLayout>(R.id.sakramenty_layout)
        val kontaktLayout = root.findViewById<LinearLayout>(R.id.kontakt_layout)
        val dotacjaLayout = root.findViewById<LinearLayout>(R.id.dotacja_layout)

        ogloszeniaLayout.setOnClickListener {
            intent.putExtra("kategoria", "Ogłoszenia")
            startActivity(intent)
        }
        aktualnosciLayout.setOnClickListener {
            intent.putExtra("kategoria", "Aktualności")
            startActivity(intent)
        }
        intencjeLayout.setOnClickListener {
            intent.putExtra("kategoria", "Intencje")
            startActivity(intent)
        }
        parafiaLayout.setOnClickListener {
            intent.putExtra("kategoria", "Historia parafii")
            startActivity(intent)
        }
        sakramentyLayout.setOnClickListener {
            val intent2 = Intent(activity, GalleriesActivity::class.java)
            startActivity(intent2)
        }
        kontaktLayout.setOnClickListener {
            intent.putExtra("kategoria", "Kontakt")
            startActivity(intent)
        }
        dotacjaLayout.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://parafia.ofiara.org/donatio?r=jGGhfaF7LDbW227m7lI8v73DHRi1")))
        }


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Timber.e("OnActivityCreated created")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("Siemanowice resumowice")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.dwnldFromPage(context)
    }


}
