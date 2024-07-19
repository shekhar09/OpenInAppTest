package com.shekhar.kotlin.data.remote

import android.util.Log
import com.shekhar.kotlin.data.dto.HomeRequest
import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.remote.service.HomeService
import com.shekhar.kotlin.data.repository.Resource
import com.shekhar.kotlin.utils.network.NetworkConnectivity
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {

    val TAG = "RemoteData"


    private suspend fun processCall(responseCall: suspend () -> Response<*>): ProcessCallResponse {
        if (!networkConnectivity.isConnected()) {
            return ProcessCallResponse(-1,
                CommonResponse(message = "No internet connection", status = "failed")
            )
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {

                Log.e(TAG,"Success " +response.body())
                ProcessCallResponse(responseCode, response.body())

            } else {

                val remoteResponse: String = response.errorBody()!!.string()

                Log.e(TAG, "Fail $remoteResponse")

                if (remoteResponse.contains("<html>") || remoteResponse.contains("<h1>Not Found"))
                {
                    ProcessCallResponse(responseCode, CommonResponse(message = remoteResponse, status = "Failed"))
                }
                else
                {
                    Log.e(TAG, "Fail remoteResponse $remoteResponse")
                    val jObjError = JSONObject(remoteResponse)
                    ProcessCallResponse(responseCode, CommonResponse(message = jObjError.getString("message"), status = jObjError.getString("status")))
                }
            }
        } catch (e: IOException) {
            ProcessCallResponse(-1,CommonResponse(message = e.message!!, status = "failed" ))
        }
    }

    override suspend fun requestHomeData(token: String): Resource<HomeResponse> {
        val homeService = serviceGenerator.createService(HomeService::class.java)

        val response = processCall{homeService.fetchHomeData(token)}

        return if (response.responseCode in 200..299) {
            Resource.Success(data = response.responseBody as HomeResponse, statusCode = response.responseCode)
        } else if(response.responseCode == -1) {
            Resource.DataError(data = response.responseBody as String, statusCode = response.responseCode)
        } else {
            Resource.DataError(data = response.responseBody as HomeResponse, statusCode = response.responseCode)
        }
    }


    suspend fun setIncognitoMode(homeRequest: HomeRequest, id : String, token : String): Resource<CommonResponse> {
        val homeService = serviceGenerator.createService(HomeService::class.java)

        val response = processCall{homeService.updateHomeData(homeRequest,id,token)}

        return if (response.responseCode in 200..299) {
            Resource.Success(data = response.responseBody as CommonResponse, statusCode = response.responseCode)
        } else {
            Resource.DataError(data = response.responseBody as CommonResponse, statusCode = response.responseCode)
        }

    }



}

