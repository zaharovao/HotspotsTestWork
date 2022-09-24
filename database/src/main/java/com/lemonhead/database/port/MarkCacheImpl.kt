package com.lemonhead.database.port

import com.lemonhead.database.room.dao.MarkDao
import com.lemonhead.database.room.models.MarkDBModel
import com.lemonhead.domain.business.mark.entity.MarkEntity
import com.lemonhead.domain.business.mark.port.IMarkCache

class MarkCacheImpl(
    private val markDao: MarkDao,
) : IMarkCache {

    private val dbModelMapper = MarkDBModel.DBModelMapper()

    override suspend fun getMarksFromDatabase(): List<MarkEntity> {
        return markDao.getMarks().map { dbModelMapper.mapToEntity(it) }
    }

    override suspend fun insertMarksToDatabase(marks: List<MarkEntity>) {
        markDao.insert(*marks.map { dbModelMapper.mapFromEntity(it) }.toTypedArray())
    }
}