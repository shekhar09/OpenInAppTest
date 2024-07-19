package com.shekhar.kotlin.data.remote

import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.repository.Resource


internal interface RemoteDataSource {

    suspend fun requestHomeData(token: String): Resource<HomeResponse>
}
