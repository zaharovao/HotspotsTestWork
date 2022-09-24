package com.lemonhead.database.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.lemonhead.database.room.models.MarkDBModel

@Dao
interface MarkDao : BaseDao<MarkDBModel> {
    @Query("SELECT * FROM marks")
    suspend fun getMarks(): List<MarkDBModel>

    @Query("DELETE FROM marks")
    suspend fun deleteAll()

    @Query("SELECT * FROM marks WHERE id=:markId")
    suspend fun getMarkById(markId: String): MarkDBModel?
}