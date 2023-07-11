package com.travel.global.result


object ResultSet {
    fun resultData(obj: Any): ResultApi {
         return ResultApi(ResultType.resultData(obj));
    }

    fun resultList(list: List<*>): ResultApi {
        return ResultApi(ResultType.resultList(list, null))
    }

    @JvmOverloads
    fun resultList(list: List<*>, listCount: Long?): ResultApi {
        return ResultApi(ResultType.resultList(list, listCount))
    }
}

