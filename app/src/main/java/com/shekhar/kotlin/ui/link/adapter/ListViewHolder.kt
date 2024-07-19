package com.shekhar.kotlin.ui.link.adapter

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shekhar.kotlin.dagger.databinding.ItemDataBinding
import com.shekhar.kotlin.data.dto.DataModel
import com.shekhar.kotlin.ui.base.listeners.RecyclerItemListener
import com.shekhar.kotlin.utils.display.ScreenUtils


class ListViewHolder(private val binding: ItemDataBinding, private val activity: Activity) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: DataModel, item: RecyclerItemListener, position: Int, mSelectedItem: Int)
    {

        binding.tvItemName.text = model.title
        binding.tvItemDate.text = ScreenUtils.formatServerDate(model.createdAt)
        binding.tvItemClicks.text = model.totalClicks
        binding.tvLink.text = model.webLink

        Glide.with(activity)
            .load(model.originalImage)
//            .placeholder(ContextCompat.getDrawable(activity, R.drawable.img_placeholder_dark))
            .centerCrop()
            .into(binding.ivItem)


        binding.tvLink.setOnClickListener {
            item.onItemClick(model,position)
        }


        binding.ivCopy.setOnClickListener {
            item.onItemCopy(model,position)
        }

    }
}

