package com.shekhar.kotlin.data.repository

import com.shekhar.kotlin.data.dto.HomeRequest
import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.remote.CommonResponse
import kotlinx.coroutines.flow.Flow
interface DataRepositorySource {
    suspend fun requestHomeData(): Flow<Resource<HomeResponse>>
    suspend fun setHomeData(homeRequest: HomeRequest): Flow<Resource<CommonResponse>>
}
