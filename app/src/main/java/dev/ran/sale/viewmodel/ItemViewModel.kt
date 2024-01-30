package dev.ran.sale.viewmodel

import androidx.lifecycle.ViewModel
import dev.ran.sale.model.Item
import kotlin.random.Random

class ItemViewModel : ViewModel() {

    val itemList: List<Item> = generateItemList()

    private fun generateItemList(): List<Item> {
        val itemNameList = listOf(
            "Toothpaste", "Toothbrush", "Hand Soap", "Mouthwash", "Candies",
            "Cotton", "Body wash", "Floss", "Electric Toothbrush", "Cologne"
        )

        val itemPriceList = List(10) { Random.nextDouble(1.0, 50.0) }

        return itemNameList.mapIndexed { index, itemName ->
            val formattedPrice = String.format("%.2f", itemPriceList[index])
            Item(itemName, formattedPrice.toDouble())
        }
    }

    fun getTotalAmount(): Double {
        var totalAmount = 0.0
        for (item in itemList) {
            totalAmount += item.price
        }
        return String.format("%.2f", totalAmount).toDouble()
    }
}