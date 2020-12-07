package pl.godziszewo.kosciol.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kotlinx.android.synthetic.main.wybor_fragment.*
import pl.godziszewo.kosciol.R

class InfoFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFragment()
    }

    private lateinit var viewModel: InfoViewModel
    lateinit var mAdView: AdView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.wybor_fragment, container, false)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)

        val req = RequestConfiguration.Builder()
            .setTestDeviceIds(listOf("6BAFF71222ABE5046B2841CF75F38B42")).build()
        MobileAds.setRequestConfiguration(req)
        MobileAds.initialize(context) {}
        mAdView = root.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)

        val kategoria = activity?.intent?.getStringExtra("kategoria")
        activity?.title = if (kategoria == "Historia parafii") "Parafia" else kategoria
        var dod = ""
        viewModel.allSpanstr.observe(viewLifecycleOwner, {
            it.forEach { biblia ->
                if (kategoria == "Historia parafii") {
                    if (biblia.ksiega == kategoria || biblia.ksiega == "Cmentarz" || biblia.ksiega == "Nasz patron")
                        dod += biblia.werset
                    messag.text = viewModel.naSpanned(dod)
                } else if (biblia.ksiega == kategoria) {
                    messag.text = viewModel.naSpanned(biblia.werset)
                }
            }

        })
//        Toast.makeText(context, kategoria, Toast.LENGTH_SHORT).show()

    }

}
