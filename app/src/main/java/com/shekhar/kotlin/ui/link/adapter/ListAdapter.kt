package com.shekhar.kotlin.ui.link.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shekhar.kotlin.dagger.databinding.ItemDataBinding
import com.shekhar.kotlin.data.dto.DataModel
import com.shekhar.kotlin.ui.base.listeners.RecyclerItemListener
import com.shekhar.kotlin.ui.link.LinkViewModel


class ListAdapter(
    private val viewModel: LinkViewModel,
    private var list: List<DataModel>,
    private val activity: Activity,
    private val clickListener :RecyclerItemListener
) : RecyclerView.Adapter<ListViewHolder>() {

    private var mSelectedItem: Int = -1

    private val onItemClickListener: RecyclerItemListener = object :
        RecyclerItemListener {
        override fun onItemCopy(item: DataModel, position: Int) {
            clickListener.onItemCopy(item,position)
        }

        override fun onItemClick(item: DataModel, position: Int) {
            clickListener.onItemClick(item,position)
        }
    }


    fun updateList(mList: List<DataModel>) {
        list = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemBinding,activity)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position], onItemClickListener,position,mSelectedItem)
    }

    override fun getItemCount(): Int {
        return list.size
//        return 5
    }
}

