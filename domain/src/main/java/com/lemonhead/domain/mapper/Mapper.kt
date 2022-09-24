package com.lemonhead.domain.mapper

abstract class Mapper<T, D> {
    abstract fun mapToEntity(from: T): D

    abstract fun mapFromEntity(from: D): T
}