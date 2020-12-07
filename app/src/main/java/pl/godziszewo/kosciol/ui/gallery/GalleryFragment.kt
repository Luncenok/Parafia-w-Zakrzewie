package pl.godziszewo.kosciol.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private lateinit var viewModel: GalleryViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var mAdView: AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.gallery_fragment, container, false)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        val req = RequestConfiguration.Builder()
            .setTestDeviceIds(listOf("6BAFF71222ABE5046B2841CF75F38B42")).build()
        MobileAds.setRequestConfiguration(req)
        MobileAds.initialize(context) {}
        mAdView = root.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        recyclerView = root.findViewById(R.id.gallery_recyclerview)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        val galleryRecyclerAdapter = context?.let { GalleryRecyclerAdapter(it) }

        val link = activity?.intent?.getIntExtra("link", 0)
        viewModel.allGalleryInfo.observe(viewLifecycleOwner, { list ->
            list.forEach { gi ->
                if (gi.id == link) {
                    val linki = gi.linki.split(",")
                    galleryRecyclerAdapter?.setItems(linki)
                    Timber.e("ustawniono")
                }
            }
        })

        recyclerView.apply {
            adapter = galleryRecyclerAdapter
            addItemDecoration(TopSpacingItemDecoration(10))
            layoutManager = LinearLayoutManager(context)
        }

    }

}
