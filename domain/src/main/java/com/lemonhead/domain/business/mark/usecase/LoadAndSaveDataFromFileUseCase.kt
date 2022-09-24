package com.lemonhead.domain.business.mark.usecase

import com.lemonhead.domain.business.loading.port.IDataLoadService
import com.lemonhead.domain.business.mark.port.IMarkCache

class LoadAndSaveDataFromFileUseCase(
    private val loadService: IDataLoadService,
    private val markService: IMarkCache,
) {
    suspend fun execute(path: String) {
        val marks = loadService.loadDataFromFile(path)
        markService.insertMarksToDatabase(marks)
    }
}