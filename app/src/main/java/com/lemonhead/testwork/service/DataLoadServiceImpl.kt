package com.lemonhead.testwork.service

import android.content.Context
import androidx.core.net.toUri
import com.lemonhead.domain.business.exception.EmptyFileException
import com.lemonhead.domain.business.exception.IncorrectPathException
import com.lemonhead.domain.business.loading.port.IDataLoadService
import com.lemonhead.domain.business.mark.entity.MarkEntity
import java.io.BufferedReader
import java.io.InputStreamReader

class DataLoadServiceImpl(
    private val context: Context,
) : IDataLoadService {

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun loadDataFromFile(path: String): List<MarkEntity> {
        val csvFile =
            context.contentResolver.openInputStream(path.toUri()) ?: throw IncorrectPathException()
        val isr = InputStreamReader(csvFile)
        val strings = BufferedReader(isr).readLines()
        return if (strings.isNotEmpty()) {
            strings.map { toCoordinate(it) }
        } else {
            throw EmptyFileException()
        }
    }

    private fun toCoordinate(line: String): MarkEntity {
        val cords = line.split(",")
        return MarkEntity(cords[0], cords[1].toLong(), cords[2].toLong())
    }
}