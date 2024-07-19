package com.shekhar.kotlin.data.remote.service


import com.shekhar.kotlin.data.dto.HomeRequest
import com.shekhar.kotlin.data.dto.HomeResponse
import retrofit2.Response
import retrofit2.http.*



interface HomeService {

    @Headers("Content-type: application/json")
    @GET("v1/dashboardNew")
    suspend fun fetchHomeData(
        @Header("Authorization") token: String
    ): Response<HomeResponse>

    @Headers("Content-type: application/json")
    @POST("v1/dashboardNew")
    suspend fun updateHomeData(
        @Body requestBody: HomeRequest,
        @Path("id") id:String,
        @Header("Authorization") token: String
    ): Response<HomeResponse>

}
