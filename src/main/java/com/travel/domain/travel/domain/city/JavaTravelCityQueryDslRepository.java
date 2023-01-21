//package com.travel.domain.travel.domain.city;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//import static com.travel.domain.travel.domain.city.QTravelCity.travelCity;
//
//@Repository
//public class JavaTravelCityQueryDslRepository {
//    private final JPAQueryFactory queryFactory;
//
//    public TravelCityQueryDslRepository(EntityManager em) {
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
//    public void deleteAllToTravelId(Long travelId) {
//        queryFactory.delete(travelCity).where(travelCity.travelId.eq(travelId)).execute();
//    }
//
//
//
//
//}
