/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:52 PM
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
import pl.godziszewo.kosciol.BuildConfig
import pl.godziszewo.kosciol.databinding.ItemInfoListBinding
import pl.godziszewo.kosciol.kosciolui.base.BaseAdapter
import javax.inject.Inject

class InfoAdapter @Inject constructor(
    //private val glide: RequestManager
) : BaseAdapter<List<String>>() {

    private val diffCallback = object : DiffUtil.ItemCallback<List<String>>() {
        override fun areItemsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem.count() == newItem.count()
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemInfoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }

    inner class AdapterViewHolder(private val binding: ItemInfoListBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<List<String>> {
        override fun bind(item: List<String>) {
            binding.apply {

                item.joinToString("<br>")
                    .replace("href=\"/", "href=\"${BuildConfig.BASE_URL}/")
                    .let {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            infoText.text = Html.fromHtml(it, Html.FROM_HTML_MODE_COMPACT)
                        } else {
                            @Suppress("DEPRECATION")
                            infoText.text = Html.fromHtml(it)
                        }
                }

                infoText.movementMethod = LinkMovementMethod.getInstance()
                //glide.load(item.image).into(imageViewNews)
            }
        }
    }
}
