package com.lemonhead.testwork.model

import com.lemonhead.domain.business.mark.entity.MarkEntity
import com.lemonhead.domain.mapper.Mapper

class MarkViewModel(
    val id: String,
    val latitude: Long,
    val longitude: Long,
) {
    class ViewModelMapper : Mapper<MarkViewModel, MarkEntity>() {
        override fun mapFromEntity(from: MarkEntity): MarkViewModel {
            return MarkViewModel(from.id, from.latitude, from.longitude)
        }

        override fun mapToEntity(from: MarkViewModel): MarkEntity {
            return MarkEntity(from.id, from.latitude, from.longitude)
        }
    }
}