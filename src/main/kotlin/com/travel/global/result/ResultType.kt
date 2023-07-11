package com.travel.global.result

import com.travel.global.constants.CommonConstants

object ResultType {
    fun resultList(list: List<*>, listCount: Long?): Map<String, Any> {
        val resultMap: MutableMap<String, Any> = HashMap()
        resultMap[CommonConstants.RESULT_LIST] = list
        resultMap[CommonConstants.RESULT_DATA] = listCount ?: 0L
        return resultMap
    }

    fun resultData(obj: Any): Map<String, Any> {
        val resultMap: MutableMap<String, Any> = HashMap()
        resultMap[CommonConstants.RESULT_DATA] = obj
        return resultMap
    }
}
