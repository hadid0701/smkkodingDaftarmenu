package com.example.daftarmenu.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahanMakanan(makananModel: MenulMakananModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahanMinuman(minumanModel: MenuMinumanModel)

    @Query("Select * from menulmakananmodel")
    fun ambilMenuMakanan():LiveData<List<MenulMakananModel>>

    @Query("Select * from MenuMinumanModel")
    fun ambilMenuMinuman():LiveData<List<MenuMinumanModel>>
}