package com.shekhar.kotlin.data.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DataModel(

    @Json(name = "url_id")
    val urlId: String = "",

    @Json(name = "web_link")
    val webLink: String = "",

    @Json(name = "smart_link")
    val smartLink: String = "",

    @Json(name = "is_favourite")
    val isFavourite: Boolean = false,

    @Json(name = "app")
    val app: String = "",

    @Json(name = "url_prefix")
    val urlPrefix: String = "",

    @Json(name = "domain_id")
    val domainId: String = "",

    @Json(name = "created_at")
    val createdAt: String = "",

    @Json(name = "times_ago")
    val timesAgo: String = "",

    @Json(name = "thumbnail")
    val thumbnail: String = "",

    @Json(name = "original_image")
    val originalImage: String = "",

    @Json(name = "total_clicks")
    val totalClicks: String = "",

    @Json(name = "title")
    val title: String = ""


) : Parcelable