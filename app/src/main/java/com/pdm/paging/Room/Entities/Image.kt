package com.pdm.paging.Room.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image")
data class Image(

        @PrimaryKey(autoGenerate = true)
        var id:Int,

        val path:String
)