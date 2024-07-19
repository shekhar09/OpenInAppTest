package com.shekhar.kotlin.data.repository

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
    val data: Any? = null,
    val statusCode: Int? = null
) {
    class Success<T>(data: Any?, statusCode:Int) : Resource<T>(data,statusCode)
    class Loading<T>(data: String? = null) : Resource<T>(data,-1)
    class DataError<T>(data: Any?, statusCode:Int) : Resource<T>(data, statusCode)
    class SessionError<T>(error: String?, statusCode:Int) : Resource<T>(error, statusCode)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is DataError -> "Error[exception=$statusCode]"
            is SessionError -> "SessionError[exception=$statusCode]"
            is Loading<T> -> "Loading"
        }
    }
}
