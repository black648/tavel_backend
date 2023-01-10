package com.travel.domain.city.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CityRepository extends JpaRepository<City, Long> {
@Query(value =  "SELECT CITY.Id, CITY.Name " +
                "FROM (" +
                "    (SELECT C.Id, C.Name" +
                "     FROM CITY C" +
                "              JOIN TRAVEL_CITY TC ON C.Id = TC.City_id" +
                "              JOIN (SELECT Id, Travel_start_date fROM TRAVEL WHERE User_id = ?1" +
                "                                                               and DATE_FORMAT(STR_TO_DATE(Travel_start_date, '%Y%m%d'), '%Y-%m-%d %H:%i:%s') <= NOW()" +
                "                                                               and DATE_FORMAT(DATE_ADD(STR_TO_DATE(Travel_end_date, '%Y%m%d'), INTERVAL 1 DAY), '%Y-%m-%d %H:%i:%s') >= NOW()" +
                "     ) T ON T.Id = TC.Travel_id" +
                "     ORDER BY DATE_FORMAT(STR_TO_DATE(T.Travel_start_date, '%Y%m%d'), '%Y-%m-%d %H:%i:%s') ASC)" +
                "    UNION ALL" +
                "    (SELECT DISTINCT COMBINE.Id, COMBINE.Name FROM (" +
                "                                                       (SELECT C.Id, C.Name" +
                "                                                        FROM CITY C" +
                "                                                                 JOIN Travel_city TC ON C.Id = TC.City_id" +
                "                                                                 JOIN (SELECT Id, Travel_start_date FROM TRAVEL WHERE User_id = ?1" +
                "                                                                                                                  AND DATE_FORMAT(STR_TO_DATE(Travel_start_date, '%Y%m%d'), '%Y-%m-%d %H:%i:%s') >= NOW()" +
                "                                                        ) T ON T.Id = TC.Travel_id" +
                "                                                        ORDER BY DATE_FORMAT(STR_TO_DATE(T.Travel_start_date, '%Y%m%d'), '%Y-%m-%d %H:%i:%s') ASC)" +
                "                                                       UNION ALL" +
                "                                                       (SELECT C.Id, C.Name" +
                "                                                        FROM CITY C" +
                "                                                                 JOIN Travel_city TC ON C.Id = TC.City_id" +
                "                                                                 JOIN (SELECT Id, Travel_start_date FROM TRAVEL WHERE User_id = ?1) T ON T.Id = TC.Travel_id" +
                "                                                        wHERE TC.Create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 DAY ) AND NOW()" +
                "                                                        ORDER BY DATE_FORMAT(STR_TO_DATE(TC.Create_date, '%Y%m%d'), '%Y-%m-%d %H:%i:%s') ASC)" +
                "                                                       UNION ALL" +
                "                                                       (SELECT C.Id, C.Name" +
                "                                                        FROM City C" +
                "                                                                 JOIN (SELECT City_id, Create_date FROM CITY_LOG WHERE User_id=?1 AND Create_date BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK ) AND NOW())CL ON C.Id = CL.City_id" +
                "                                                        ORDER BY CL.Create_date DESC)" +
                "                                                   ) COMBINE LIMIT 10)" +
                ") city", nativeQuery = true, countProjection = "id")
    List<Map<String, Object>> findCityListByUserIdNative(String userId);
}

