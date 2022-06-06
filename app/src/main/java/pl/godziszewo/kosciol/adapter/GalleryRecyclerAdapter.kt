package pl.godziszewo.kosciol.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pl.godziszewo.kosciol.R

class GalleryRecyclerAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<GalleryRecyclerAdapter.ViewHolder>() {

    private var items = emptyList<String>()
    private var mContext = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var galleryImage: ImageView = itemView.findViewById(R.id.gallery_image)

        fun bind(link: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_holy_ghost)
                .error(R.drawable.ic_holy_ghost)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(link)
                .into(galleryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gallery_element, parent, false)
        )

    override fun getItemCount(): Int = items.size

    internal fun setItems(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}