package pl.godziszewo.kosciol.ui.galleries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.adapter.GalleriesRecyclerAdapter
import pl.godziszewo.kosciol.utils.TopSpacingItemDecoration
import timber.log.Timber

class GalleriesFragment : Fragment() {

    companion object {
        fun newInstance() = GalleriesFragment()
    }

    private lateinit var viewModel: GalleriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.galleries_fragment, container, false)

        val recyclerView: RecyclerView = root.findViewById(R.id.galleries_recycler)
        viewModel = ViewModelProvider(this).get(GalleriesViewModel::class.java)
        val galleriesRecyclerAdapter = context?.let { GalleriesRecyclerAdapter() }
        recyclerView.apply {
            adapter = galleriesRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
            val topSpacingItemDecoration = TopSpacingItemDecoration(10)
            addItemDecoration(topSpacingItemDecoration)
        }
        viewModel.dwnldcontent()

        viewModel.allGalleryInfo.observe(viewLifecycleOwner) {
            galleriesRecyclerAdapter?.setItems(it)
            Timber.e(it.toString())
        }

        return root
    }

}
