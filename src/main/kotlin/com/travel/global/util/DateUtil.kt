package com.travel.global.util

import org.springframework.util.StringUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateUtil {
    val YYYYMMDD = SimpleDateFormat("yyyyMMdd")

    //String To Date
    @Throws(ParseException::class)
    fun convertDate(str: String?, dateFormat: SimpleDateFormat): Date {
        return Date(dateFormat.parse(str).time)
    }

    //A가 B보다 크면 true
    fun compareTo(a: Date, b: Date?): Boolean {
        return a > b
    }

    @Throws(ParseException::class)
    fun compareTo(a: String?, b: String?): Boolean {
        return if (StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
            false
        } else compareTo(convertDate(a, YYYYMMDD), convertDate(b, YYYYMMDD))
    }
}

