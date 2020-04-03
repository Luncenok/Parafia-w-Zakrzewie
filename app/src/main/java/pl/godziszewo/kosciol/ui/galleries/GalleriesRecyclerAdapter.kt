package pl.godziszewo.kosciol.ui.galleries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.database.GalleryInfo
import pl.godziszewo.kosciol.ui.gallery.GalleryActivity

class GalleriesRecyclerAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<GalleriesRecyclerAdapter.ViewHolder>() {

    private var items = emptyList<GalleryInfo>()
    private var mContext = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var galleryImage: ImageView = itemView.findViewById(R.id.galleries_image)
        private var galleryTitle: TextView = itemView.findViewById(R.id.galleries_title)
        private var galleryDate: TextView = itemView.findViewById(R.id.galleries_date)
        private var galleryContainer: ConstraintLayout = itemView.findViewById(R.id.galleries_container)

        fun bind(galleryInfo: GalleryInfo) {
            galleryTitle.text = galleryInfo.title
            galleryDate.text = galleryInfo.date
            galleryContainer.setOnClickListener {
                val intent = Intent(mContext, GalleryActivity::class.java)
                intent.putExtra("link", galleryInfo.id)
                mContext.startActivity(intent)
            }
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_holy_ghost)
                .error(R.drawable.ic_holy_ghost)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(galleryInfo.photosrc)
                .into(galleryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.galleries_element, parent, false)
        )

    override fun getItemCount(): Int = items.size

    internal fun setItems(items: List<GalleryInfo>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}