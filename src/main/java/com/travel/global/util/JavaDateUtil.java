//package com.travel.global.util;
//
//import org.springframework.util.StringUtils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class DateUtil {
//    public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
//
//    //String To Date
//    public static Date convertDate(String str, SimpleDateFormat dateFormat) throws ParseException {
//        return new Date(dateFormat.parse(str).getTime());
//    }
//
//    //A가 B보다 크면 true
//    public static boolean compareTo(Date a, Date b) {
//        return a.compareTo(b) > 0;
//    }
//
//    public static boolean compareTo(String a, String b) throws ParseException {
//        if( StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
//            return false;
//        }
//        return compareTo(convertDate(a, YYYYMMDD), convertDate(b, YYYYMMDD));
//    }
//}
