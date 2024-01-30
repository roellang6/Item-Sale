package dev.ran.sale.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ran.sale.R
import dev.ran.sale.model.Item

class ItemAdapter(private var itemLit: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewDataClas>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewDataClas(
        LayoutInflater.from(parent.context).inflate(
            R.layout.list_sale_layout, parent, false
        )
    )

    override fun getItemCount(): Int {
        return itemLit.size
    }

    override fun onBindViewHolder(holder: ViewDataClas, position: Int) {
        holder.bindData(itemLit[position])
    }

    class ViewDataClas(v: View) : RecyclerView.ViewHolder(v) {
        private val vName = v.findViewById<TextView>(R.id.nameTextView)
        private val vPrice = v.findViewById<TextView>(R.id.priceTextView)
        fun bindData(item: Item) {
            vName.text = item.name
            val txtPrice = "$ ${item.price}"
            vPrice.text = txtPrice
        }

    }
}