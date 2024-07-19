package com.shekhar.kotlin.utils.display

import android.content.res.Resources
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object ScreenUtils {

    fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels

    fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels

    fun formatServerDate(serverDate: String): String {
        var ourdate: String
        val serverDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        val outputDateFormat = "dd MMM yyy"
        try {
            val calendar = Calendar.getInstance()
            val formatter = SimpleDateFormat(serverDateFormat, Locale.getDefault())
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            val value = formatter.parse(serverDate)
            val timeZone = calendar.timeZone
            val dateFormatter = SimpleDateFormat(outputDateFormat, Locale.getDefault()) //this format changeable
            dateFormatter.timeZone = timeZone
            ourdate = dateFormatter.format(value)
            String.format(ourdate, "0000-00-00")
        } catch (e: Exception) {
            e.printStackTrace()
            ourdate = " "
        }
        return ourdate
    }


    fun getGreetings() : String
    {
        //Get the time of day
        var greeting = ""
        val date = Date()
        val cal: Calendar = Calendar.getInstance()
        cal.setTime(date)
        val hour: Int = cal.get(Calendar.HOUR_OF_DAY)


        if(hour>= 12 && hour < 17){
            greeting = "Good Afternoon";
        } else if(hour >= 17 && hour < 21){
            greeting = "Good Evening";
        } else if(hour >= 21 && hour < 24){
            greeting = "Good Night";
        } else {
            greeting = "Good Morning";
        }

        return greeting
    }
}