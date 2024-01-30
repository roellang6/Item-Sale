package dev.ran.sale.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ran.sale.R
import dev.ran.sale.adapter.ItemAdapter
import dev.ran.sale.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var rvSale: RecyclerView
    private lateinit var saleTotal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSale = findViewById(R.id.listSale)
        saleTotal = findViewById(R.id.totalTextView)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        itemAdapter = ItemAdapter(itemViewModel.itemList)
        rvSale.layoutManager = LinearLayoutManager(this)
        rvSale.adapter = itemAdapter

        val totalAmount = "$ ${itemViewModel.getTotalAmount()}"
        saleTotal.text = totalAmount
    }
}