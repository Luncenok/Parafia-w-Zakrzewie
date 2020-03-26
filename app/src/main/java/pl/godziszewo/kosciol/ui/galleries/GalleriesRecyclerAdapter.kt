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
import pl.godziszewo.kosciol.ui.info.InfoActivity

class GalleriesRecyclerAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<GalleriesRecyclerAdapter.ViewHolder>() {

    private var items = emptyList<GalleryInfo>()
    private var mContext = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var galleryImage: ImageView = itemView.findViewById(R.id.gallery_image)
        var galleryTitle: TextView = itemView.findViewById(R.id.gallery_title)
        var galleryDate: TextView = itemView.findViewById(R.id.gallery_date)
        var galleryContainer: ConstraintLayout = itemView.findViewById(R.id.gallery_container)

        fun bind(galleryInfo: GalleryInfo) {
            galleryTitle.text = galleryInfo.title
            galleryDate.text = galleryInfo.date
            galleryContainer.setOnClickListener {
                val intent = Intent(mContext, InfoActivity::class.java)
                intent.putExtra("kategoria", galleryInfo.link)
                mContext.startActivity(intent)
            }
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
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