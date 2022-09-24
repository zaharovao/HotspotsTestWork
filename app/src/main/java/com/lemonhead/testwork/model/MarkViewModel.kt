package com.lemonhead.testwork.model

import com.lemonhead.domain.business.mark.entity.MarkEntity
import com.lemonhead.domain.mapper.Mapper
import com.yandex.mapkit.geometry.Point

class MarkViewModel(
    val id: String,
    val latitude: Double,
    val longitude: Double,
) {
    fun toPoint(): Point {
        return Point(latitude, longitude)
    }

    class ViewModelMapper : Mapper<MarkViewModel, MarkEntity>() {
        override fun mapFromEntity(from: MarkEntity): MarkViewModel {
            return MarkViewModel(from.id, from.latitude, from.longitude)
        }

        override fun mapToEntity(from: MarkViewModel): MarkEntity {
            return MarkEntity(from.id, from.latitude, from.longitude)
        }
    }
}