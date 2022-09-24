package com.lemonhead.domain.business.mark.port

import com.lemonhead.domain.business.mark.entity.MarkEntity

interface IMarkCache {
    suspend fun getMarksFromDatabase(): List<MarkEntity>
    suspend fun insertMarksToDatabase(marks: List<MarkEntity>)
}