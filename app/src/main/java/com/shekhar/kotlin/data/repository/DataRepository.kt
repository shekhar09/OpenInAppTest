package com.shekhar.kotlin.data.repository


import com.shekhar.kotlin.data.dto.HomeRequest
import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.local.LocalData
import com.shekhar.kotlin.data.remote.CommonResponse
import com.shekhar.kotlin.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val localRepository: LocalData,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {


    //Data call function
    override suspend fun requestHomeData(): Flow<Resource<HomeResponse>> {
        return flow {
            emit(remoteRepository.requestHomeData(localRepository.getUserToken()))
        }.flowOn(ioDispatcher)
    }


    //Dummy post call function
    override suspend fun setHomeData(homeRequest: HomeRequest): Flow<Resource<CommonResponse>> {
        return flow {
            emit(remoteRepository.setIncognitoMode(homeRequest,"user_id",localRepository.getUserToken()))
        }.flowOn(ioDispatcher)
    }





}
