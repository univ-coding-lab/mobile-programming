package com.example.cweek12.week12.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemTable")
data class ItemEntity(
    var itemName: String,
    var itemQuantity: Int,
    @PrimaryKey(autoGenerate = true)
    var itemID: Int = 0
)
