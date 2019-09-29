package com.example.daftarmenu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(
        MenulMakananModel::class
        , MenuMinumanModel::class
    ), version = 1
)
abstract class MenuDB : RoomDatabase() {

    abstract fun menuDao(): MenuDao

    companion object {
        var INSTANCE: MenuDB? = null
        fun getInstance(context: Context): MenuDB? {
            if (INSTANCE == null) {
                synchronized(MenuDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, MenuDB::class.java, "menuDB"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {

        }
    }
}