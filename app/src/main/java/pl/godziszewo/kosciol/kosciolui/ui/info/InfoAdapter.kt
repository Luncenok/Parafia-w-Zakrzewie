/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.ui.info

import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pl.godziszewo.kosciol.databinding.ItemInfoListBinding
import pl.godziszewo.kosciol.domain.models.News
import pl.godziszewo.kosciol.kosciolui.base.BaseAdapter
import javax.inject.Inject

class InfoAdapter @Inject constructor(
    //private val glide: RequestManager
) : BaseAdapter<News>() {

    private val diffCallback = object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemInfoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    inner class NewsViewHolder(private val binding: ItemInfoListBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<News> {
        override fun bind(item: News) {
            binding.apply {

                item.elements.joinToString("<br>").let {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        infoText.text = Html.fromHtml(it, Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        infoText.text = Html.fromHtml(it)
                    }
                }

                infoText.movementMethod = LinkMovementMethod.getInstance()
                //glide.load(item.image).into(imageViewNews)
            }
        }
    }
}
