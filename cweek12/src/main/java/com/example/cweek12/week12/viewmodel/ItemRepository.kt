package com.example.cweek12.week12.viewmodel

import com.example.cweek12.week12.roomDB.ItemDatabase
import com.example.cweek12.week12.roomDB.ItemEntity
import kotlinx.coroutines.flow.map

class ItemRepository(private val db: ItemDatabase) {
    val dao = db.getItemDao()

    suspend fun InsertItem(itemEntity: ItemEntity) {
        dao.InsertItem(itemEntity)
    }

    suspend fun UpdateItem(itemEntity: ItemEntity) {
        dao.UpdateItem(itemEntity)
    }

    suspend fun DeleteItem(itemEntity: ItemEntity) {
        dao.DeleteItem(itemEntity)
    }

    fun getAllItems() = dao.getAllItems()

    fun getItems(itemName: String) = dao.getItems(itemName)

    fun getAllDescItems() = dao.getAllItems().map { list ->
        list.sortedByDescending { it.itemQuantity }
    }
}
