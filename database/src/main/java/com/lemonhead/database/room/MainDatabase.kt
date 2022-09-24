package com.lemonhead.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lemonhead.database.room.dao.MarkDao
import com.lemonhead.database.room.models.MarkDBModel

@Database(
    entities = [
        MarkDBModel::class
    ],
    version = 1
)
// TODO("Add type converters for lists")
abstract class MainDatabase : RoomDatabase() {

    abstract fun getMarkDao(): MarkDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        private const val DB_NAME = "marks_db"

        fun getDatabase(context: Context): MainDatabase {
            if (INSTANCE != null) {
                return INSTANCE ?: throw IllegalStateException("Room database isn't initialized")
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context, MainDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}