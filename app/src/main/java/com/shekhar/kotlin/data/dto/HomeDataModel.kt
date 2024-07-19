package com.shekhar.kotlin.data.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class HomeDataModel(

    @Json(name = "recent_links")
    val recentLinks:  List<DataModel> ?,

    @Json(name = "top_links")
    val topLinks:  List<DataModel> ?,

//    @Json(name = "favourite_links")
//    val favouriteLinks:  List<FavouriteDataModel> ?,

    @Json(name = "overall_url_chart")
    val overallUrlChart:  Map<String, Int> = emptyMap<String, Int>(),
) : Parcelable