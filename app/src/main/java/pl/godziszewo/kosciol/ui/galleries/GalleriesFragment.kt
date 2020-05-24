package pl.godziszewo.kosciol.ui.galleries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.utils.TopSpacingItemDecoration
import timber.log.Timber

class GalleriesFragment : Fragment() {

    companion object {
        fun newInstance() = GalleriesFragment()
    }

    private lateinit var viewModel: GalleriesViewModel
    lateinit var mAdView: AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.galleries_fragment, container, false)

        val req = RequestConfiguration.Builder()
            .setTestDeviceIds(listOf("2A1965EA634A02D70CBC9CF1070DCF26")).build()
        MobileAds.setRequestConfiguration(req)
        MobileAds.initialize(context) {}
        mAdView = root.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val recyclerView: RecyclerView = root.findViewById(R.id.galleries_recyclerview)
        viewModel = ViewModelProvider(this).get(GalleriesViewModel::class.java)
        val galleriesRecyclerAdapter = context?.let { GalleriesRecyclerAdapter(it) }
        recyclerView.apply {
            adapter = galleriesRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
            val topSpacingItemDecoration = TopSpacingItemDecoration(10)
            addItemDecoration(topSpacingItemDecoration)
        }
        viewModel.dwnldcontent()

        viewModel.allGalleryInfo.observe(viewLifecycleOwner, Observer {
            galleriesRecyclerAdapter?.setItems(it)
            Timber.e(it.toString())
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.e("onActivityCreated created")
        super.onActivityCreated(savedInstanceState)
    }

}
