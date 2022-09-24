package com.lemonhead.domain.business.mark.usecase

import com.lemonhead.domain.business.exception.MarksNotFindInDatabaseException
import com.lemonhead.domain.business.mark.entity.MarkEntity
import com.lemonhead.domain.business.mark.port.IMarkCache

class GetMarksFromDatabaseUseCase(
    private val markService: IMarkCache
) {
    suspend fun execute(): List<MarkEntity> {
        val marks = markService.getMarksFromDatabase()
        return if (marks.isNotEmpty()) {
            marks
        } else {
            throw MarksNotFindInDatabaseException()
        }
    }
}