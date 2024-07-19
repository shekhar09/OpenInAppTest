package com.shekhar.kotlin.data.remote

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CommonResponse(

    @Json(name = "message")
    val message: String = "",

    @Json(name = "status")
    val status: String = ""

) : Parcelable


