package com.pdm.paging.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm.paging.Room.Dao.ImageDao
import com.pdm.paging.Room.Entities.Image

@Database(entities = [Image::class], version = 4, exportSchema = false)
abstract class ImageDB: RoomDatabase() {

    abstract fun imageDao():ImageDao

    companion object {
        @Volatile
        private var INSTANCE: ImageDB? = null

        fun getInstance(
                context: Context
        ): ImageDB {

            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                synchronized(this) {
                    INSTANCE = Room
                            .databaseBuilder(context, ImageDB::class.java, "image_Database")
                            .fallbackToDestructiveMigration()
                            .build()
                    return INSTANCE!!
                }
            }
        }

    }

}