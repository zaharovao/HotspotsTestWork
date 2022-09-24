package com.lemonhead.domain.business.loading.port

import com.lemonhead.domain.business.mark.entity.MarkEntity

interface IDataLoadService {
    suspend fun loadDataFromFile(path: String): List<MarkEntity>
}