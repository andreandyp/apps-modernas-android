package com.andreandyp.tallerdevcirclescdmx.data

sealed class DataResult<out T> {
    data class DataSuccess<out T>(val data: T) : DataResult<T>()
    data class DataError(val exception: Exception) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()
}
