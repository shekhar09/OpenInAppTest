package com.shekhar.kotlin.ui.base.listeners

import com.shekhar.kotlin.data.dto.DataModel

interface RecyclerItemListener {
    fun onItemCopy(item: DataModel, position:Int)
    fun onItemClick(item: DataModel, position:Int)
}
