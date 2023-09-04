/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:19 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.galleries

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
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity

@Deprecated("No longer needed")
class GalleriesRecyclerAdapter :
    RecyclerView.Adapter<GalleriesRecyclerAdapter.ViewHolder>() {

    private var items = emptyList<GalleryCacheEntity>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var galleryImage: ImageView = itemView.findViewById(R.id.galleries_image)
        private var galleryTitle: TextView = itemView.findViewById(R.id.galleries_title)
        private var galleryDate: TextView = itemView.findViewById(R.id.galleries_date)
        private var galleryContainer: ConstraintLayout =
            itemView.findViewById(R.id.galleries_container)

        fun bind(galleryCacheEntity: GalleryCacheEntity) {
            galleryTitle.text = galleryCacheEntity.title
            galleryDate.text = galleryCacheEntity.date
            galleryContainer.setOnClickListener {
//                val intent = Intent(mContext, GalleryActivity::class.java)
//                intent.putExtra("link", galleryInfo.id)
//                mContext.startActivity(intent)
            }
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.dove_solid)
                .error(R.drawable.dove_solid)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(galleryCacheEntity.photosrc)
                .into(galleryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.galleries_element, parent, false)
        )

    override fun getItemCount(): Int = items.size

    internal fun setItems(items: List<GalleryCacheEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}