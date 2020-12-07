package com.fantasmaplasma.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val mContext: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var data: List<ItemPrice>? = null

    fun setData(data: List<ItemPrice>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(mContext)
                .inflate(R.layout.list_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val mProductTV = view.findViewById<TextView>(R.id.tv_item)
        private val mPriceTV = view.findViewById<TextView>(R.id.tv_price)

        fun bind(position: Int) {
            data?.get(position)?.let { currentItem ->
                mProductTV.text = currentItem.name
                mPriceTV.text = currentItem.price
            }
        }
    }

}