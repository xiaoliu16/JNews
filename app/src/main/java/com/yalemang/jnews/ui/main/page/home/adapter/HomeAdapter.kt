package com.yalemang.jnews.ui.main.page.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yalemang.jnews.R
import com.yalemang.net.bean.DataList

class HomeAdapter : BaseQuickAdapter<DataList, BaseViewHolder>(R.layout.item_home) {

    override fun convert(holder: BaseViewHolder, item: DataList) {
        holder.setText(R.id.title, item.title)
        holder.setText(R.id.shareUser, item.shareUser)
        holder.setText(R.id.niceDate, item.niceDate)
        holder.setText(R.id.superChapterName, item.superChapterName)
    }
}