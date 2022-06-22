package pl.godziszewo.kosciol.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.adapter.GalleryRecyclerAdapter
import pl.godziszewo.kosciol.databinding.GalleriesFragmentBinding
import pl.godziszewo.kosciol.utils.TopSpacingItemDecoration
import timber.log.Timber

class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: GalleriesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.gallery_fragment, container, false)
        val galleryRecyclerAdapter = GalleryRecyclerAdapter(requireContext())

        val link = activity?.intent?.getIntExtra("link", 0)
        viewModel.allGalleryInfo.observe(viewLifecycleOwner) { list ->
            list.forEach { gi ->
                if (gi.id == link) {
                    val linki = gi.linki.split(",")
                    galleryRecyclerAdapter.setItems(linki)
                    Timber.e("ustawniono")
                }
            }
        }

        binding.galleriesRecycler.apply {
            adapter = galleryRecyclerAdapter
            addItemDecoration(TopSpacingItemDecoration(10))
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

}
