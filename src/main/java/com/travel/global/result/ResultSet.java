package com.travel.global.result;

import lombok.Getter;

import java.util.List;

@Getter
public class ResultSet {

    public static ResultApi resultData(Object object) {
        ResultApi resultApi = new ResultApi();
        resultApi.setObject(ResultType.resultData(object));

        return resultApi;
    }

    public static ResultApi resultList(List<?> list) {
        return resultList(list, null);
    }

    public static ResultApi resultList(List<?> list, Long listCount) {
        ResultApi resultApi = new ResultApi();
        resultApi.setObject(ResultType.resultList(list, listCount));

        return resultApi;
    }


}
