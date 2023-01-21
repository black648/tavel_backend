//package com.travel.domain.travel.domain;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.travel.domain.travel.dto.JavaTravelRequestDto;
//import com.travel.global.util.RepositoryUtil;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//import static com.travel.domain.travel.domain.QTravel.travel;
//import static com.travel.domain.travel.domain.city.QTravelCity.travelCity;
//import static com.travel.domain.travel.domain.plan.QTravelPlan.travelPlan;
//
//@Repository
//public class JavaTravelQueryDslRepository {
//    private final JPAQueryFactory queryFactory;
//
//    public JavaTravelQueryDslRepository(EntityManager em) {
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
//    public JavaTravel get(JavaTravelRequestDto requestDto) {
//        return queryFactory.select(travel)
//                .from(travel)
//                .where(
//                        RepositoryUtil.equalsLong(requestDto.getId(), travel.id),
//                        RepositoryUtil.equals(requestDto.getName(), travel.name),
//                        RepositoryUtil.equals(requestDto.getUserId(), travel.userId),
//                        RepositoryUtil.equals(requestDto.getTravelStartDate(), travel.travelStartDate),
//                        RepositoryUtil.equals(requestDto.getTravelEndDate(), travel.travelEndDate))
//                .fetchOne();
//    }
//
//    public JavaTravel getIncludePlan(JavaTravelRequestDto requestDto) {
//        return queryFactory.select(travel)
//                .from(travel)
//                .where(
//                        RepositoryUtil.equalsLong(requestDto.getId(), travel.id),
//                        RepositoryUtil.equals(requestDto.getName(), travel.name),
//                        RepositoryUtil.equals(requestDto.getUserId(), travel.userId),
//                        RepositoryUtil.equals(requestDto.getTravelStartDate(), travel.travelStartDate),
//                        RepositoryUtil.equals(requestDto.getTravelEndDate(), travel.travelEndDate))
//                .leftJoin(travel.travelPlanList, travelPlan).fetchJoin()
//                .fetchOne();
//    }
//
//    public JavaTravel getIncludeCity(JavaTravelRequestDto requestDto) {
//        return queryFactory.select(travel)
//                .from(travel)
//                .where(
//                        RepositoryUtil.equalsLong(requestDto.getId(), travel.id),
//                        RepositoryUtil.equals(requestDto.getName(), travel.name),
//                        RepositoryUtil.equals(requestDto.getUserId(), travel.userId),
//                        RepositoryUtil.equals(requestDto.getTravelStartDate(), travel.travelStartDate),
//                        RepositoryUtil.equals(requestDto.getTravelEndDate(), travel.travelEndDate))
//                .leftJoin(travel.travelCityList, travelCity).fetchJoin()
//                .fetchOne();
//    }
//}
