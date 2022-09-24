package com.lemonhead.database.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lemonhead.domain.business.mark.entity.MarkEntity
import com.lemonhead.domain.mapper.Mapper

@Entity(tableName = "marks")
class MarkDBModel(
    @PrimaryKey
    val id: String,
    val latitude: Long,
    val longitude: Long,
) {
    class DBModelMapper : Mapper<MarkDBModel, MarkEntity>() {
        override fun mapFromEntity(from: MarkEntity): MarkDBModel {
            return MarkDBModel(from.id, from.latitude, from.longitude)
        }

        override fun mapToEntity(from: MarkDBModel): MarkEntity {
            return MarkEntity(from.id, from.latitude, from.longitude)
        }
    }
}