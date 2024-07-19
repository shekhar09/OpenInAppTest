package com.shekhar.kotlin.utils.errors


import com.shekhar.kotlin.data.error.Error
import com.shekhar.kotlin.data.error.mapper.ErrorMapper
import javax.inject.Inject


class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(statusCode: Int): Error {
        return Error(code = statusCode, description = errorMapper.errorsMap.getValue(statusCode))
    }
}
