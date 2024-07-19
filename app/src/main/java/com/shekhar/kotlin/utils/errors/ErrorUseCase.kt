package com.shekhar.kotlin.utils.errors

import com.shekhar.kotlin.data.error.Error

interface ErrorUseCase {
    fun getError(statusCode: Int): Error
}
