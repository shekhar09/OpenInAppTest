package com.shekhar.kotlin.data.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HomeResponse(

    @Json(name = "statusCode")
    val statusCode: String = "",

    @Json(name = "message")
    val message: String = "",

    @Json(name = "support_whatsapp_number")
    val supportWhatsappNumber: String = "",

    @Json(name = "extra_income")
    val extraIncome: String = "",

    @Json(name = "total_links")
    val totalLinks: String = "",

    @Json(name = "total_clicks")
    val totalClicks: String = "",

    @Json(name = "today_clicks")
    val todayClicks: String = "0",

    @Json(name = "top_source")
    val topSource: String = "-",

    @Json(name = "top_location")
    val topLocation: String = "-",

    @Json(name = "startTime")
    val startTime: String = "",

    @Json(name = "links_created_today")
    val linksCreatedToday: String = "",

    @Json(name = "applied_campaign")
    val appliedCampaign: String = "",

    @Json(name = "status")
    val status: Boolean = false,

    @Json(name = "data")
    val data:  HomeDataModel

) : Parcelable


//
//{
//    "status": true,
//    "statusCode": 200,
//    "message": "success",
//    "support_whatsapp_number": "6366989964",
//    "extra_income": 182.86,
//    "total_links": 178,
//    "total_clicks": 3483,
//    "today_clicks": 7,
//    "top_source": "Direct",
//    "top_location": "Patna",
//    "startTime": "10:00",
//    "links_created_today": 0,
//    "applied_campaign": 0,
//    "data": {
//    "recent_links": [
//    {
//        "url_id": 146150,
//        "web_link": "https://inopenapp.com/4o5qk",
//        "smart_link": "inopenapp.com/4o5qk",
//        "title": "651   Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage",
//        "total_clicks": 344,
//        "original_image": "https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-03-15T07:33:50.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "4o5qk",
//        "app": "nobroker",
//        "is_favourite": false
//    },
//    {
//        "url_id": 146110,
//        "web_link": "https://inopenapp.com/estt3",
//        "smart_link": "inopenapp.com/estt3",
//        "title": "Dailyhunt",
//        "total_clicks": 157,
//        "original_image": "https://m.dailyhunt.in/assets/img/apple-touch-icon-72x72.png?mode=pwa&ver=2.0.76",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-03-09T08:00:05.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "estt3",
//        "app": "dailyhunt",
//        "is_favourite": false
//    },
//    {
//        "url_id": 146061,
//        "web_link": "https://inopenapp.com/7113t",
//        "smart_link": "inopenapp.com/7113t",
//        "title": "MSI Katana GF66 Thin, Intel 12th Gen. i5-12450H, 40CM FHD 144Hz Gaming Laptop (16GB/512GB NVMe SSD/Windows 11 Home/Nvidia RTX3050Ti 4GB GDDR6/Black/2.25Kg), 12UD-640IN : Amazon.in: Computers & Accessories",
//        "total_clicks": 101,
//        "original_image": "https://m.media-amazon.com/images/I/81c+XOq0b+L._SY450_.jpg",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-02-23T11:45:54.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "7113t",
//        "app": "amazon",
//        "is_favourite": false
//    },
//    {
//        "url_id": 145873,
//        "web_link": "https://inopenapp.com/juixo",
//        "smart_link": "inopenapp.com/juixo",
//        "title": "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
//        "total_clicks": 80,
//        "original_image": "https://www.flipkart.com/apple-touch-icon-57x57.png",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-02-20T04:59:00.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "juixo",
//        "app": "flipkart",
//        "is_favourite": false
//    },
//    {
//        "url_id": 144236,
//        "web_link": "https://inopenapp.com/h2hok",
//        "smart_link": "inopenapp.com/h2hok",
//        "title": "Programming Jokes & MeMes | The gods have spoken",
//        "total_clicks": 81,
//        "original_image": "https://scontent-iad3-2.xx.fbcdn.net/v/t39.30808-6/325385014_1393046418172272_8557035725717444936_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=7fc0be&_nc_ohc=YYNdHpdCbiAAX9iHO5V&_nc_ht=scontent-iad3-2.xx&oh=00_AfCk2FYoD4WCCp3bqnjBxcxhQ8MEAxCw9xyInnM5sBO0VA&oe=63CD146D",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-01-18T05:40:39.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "h2hok",
//        "app": "facebook",
//        "is_favourite": false
//    }
//    ],
//    "top_links": [
//    {
//        "url_id": 81169,
//        "web_link": "https://dream.inopenapp.com/vid",
//        "smart_link": "dream.inopenapp.com/vid",
//        "title": "YouTube",
//        "total_clicks": 1016,
//        "original_image": "https://www.youtube.com/img/desktop/yt_1200.png",
//        "thumbnail": null,
//        "times_ago": "2 yr ago",
//        "created_at": "2021-12-17T10:36:05.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": "dream",
//        "url_suffix": "vid",
//        "app": "youtube",
//        "is_favourite": false
//    },
//    {
//        "url_id": 98953,
//        "web_link": "https://boyceavenue.inopenapp.com/boyce-avenue",
//        "smart_link": "boyceavenue.inopenapp.com/boyce-avenue",
//        "title": "Can't Help Falling In Love - Elvis Presley (Boyce Avenue acoustic cover) on Spotify & Apple",
//        "total_clicks": 1011,
//        "original_image": "https://i.ytimg.com/vi/G0WTFfZqjz0/maxresdefault.jpg",
//        "thumbnail": null,
//        "times_ago": "2 yr ago",
//        "created_at": "2022-01-12T13:57:49.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": "boyceavenue",
//        "url_suffix": "boyce-avenue",
//        "app": "youtube",
//        "is_favourite": false
//    },
//    {
//        "url_id": 146150,
//        "web_link": "https://inopenapp.com/4o5qk",
//        "smart_link": "inopenapp.com/4o5qk",
//        "title": "651   Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage",
//        "total_clicks": 344,
//        "original_image": "https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-03-15T07:33:50.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "4o5qk",
//        "app": "nobroker",
//        "is_favourite": false
//    },
//    {
//        "url_id": 140627,
//        "web_link": "https://amazon.inopenapp.com/b01n5qh183",
//        "smart_link": "amazon.inopenapp.com/b01n5qh183",
//        "title": "Match Women's Long Sleeve Flannel Plaid Shirt at Amazon Women’s Clothing store",
//        "total_clicks": 196,
//        "original_image": "https://m.media-amazon.com/images/I/51rE6aQt2fL._AC_.jpg",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2022-09-23T19:59:49.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": "amazon",
//        "url_suffix": "b01n5qh183",
//        "app": "amazon",
//        "is_favourite": false
//    },
//    {
//        "url_id": 146110,
//        "web_link": "https://inopenapp.com/estt3",
//        "smart_link": "inopenapp.com/estt3",
//        "title": "Dailyhunt",
//        "total_clicks": 157,
//        "original_image": "https://m.dailyhunt.in/assets/img/apple-touch-icon-72x72.png?mode=pwa&ver=2.0.76",
//        "thumbnail": null,
//        "times_ago": "1 yr ago",
//        "created_at": "2023-03-09T08:00:05.000Z",
//        "domain_id": "inopenapp.com/",
//        "url_prefix": null,
//        "url_suffix": "estt3",
//        "app": "dailyhunt",
//        "is_favourite": false
//    }
//    ],
//    "favourite_links": [],
//    "overall_url_chart": {
//        "00:00": 0,
//        "01:00": 0,
//        "02:00": 1,
//        "03:00": 0,
//        "04:00": 0,
//        "05:00": 0,
//        "06:00": 0,
//        "07:00": 0,
//        "08:00": 0,
//        "09:00": 0,
//        "10:00": 3,
//        "11:00": 1,
//        "12:00": 1,
//        "13:00": 0,
//        "14:00": 0,
//        "15:00": 1,
//        "16:00": 0,
//        "17:00": 0,
//        "18:00": 0,
//        "19:00": 0,
//        "20:00": 0,
//        "21:00": 0,
//        "22:00": 0,
//        "23:00": 0
//    }
//}
//}


