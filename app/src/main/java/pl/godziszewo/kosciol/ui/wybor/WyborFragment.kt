package pl.godziszewo.kosciol.ui.wybor

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import pl.godziszewo.kosciol.R
import kotlinx.android.synthetic.main.wybor_fragment.*
import java.util.*

class WyborFragment : Fragment() {

    companion object {
        fun newInstance() = WyborFragment()
    }

    private lateinit var viewModel: WyborViewModel
    lateinit var mAdView : AdView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.wybor_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(WyborViewModel::class.java)

        RequestConfiguration.Builder().setTestDeviceIds(listOf("2CD358774D33097FEBD7FE62A5ADE1A7"))
        MobileAds.initialize(context) {}
        mAdView = root.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().addTestDevice("2CD358774D33097FEBD7FE62A5ADE1A7").build()
        mAdView.loadAd(adRequest)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WyborViewModel::class.java)

        val kategoria = activity?.intent?.getStringExtra("kategoria")
        activity?.title = if (kategoria=="Historia parafii") "Parafia" else kategoria
        var dod: String = ""
        viewModel.allSpanstr.observe(viewLifecycleOwner, Observer {
            it.forEach { biblia ->
                if (kategoria=="Historia parafii") {
                    if (biblia.ksiega==kategoria||biblia.ksiega=="Cmentarz"||biblia.ksiega=="Nasz patron")
                        dod+=biblia.werset
                    messag.text=viewModel.naSpanned(dod)
                }
                else if (biblia.ksiega==kategoria) {
                    messag.text = viewModel.naSpanned(biblia.werset)
                }
            }

        })
//        Toast.makeText(context, kategoria, Toast.LENGTH_SHORT).show()

    }

}
