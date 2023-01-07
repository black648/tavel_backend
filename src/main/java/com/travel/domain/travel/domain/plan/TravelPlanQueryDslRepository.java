package com.travel.domain.travel.domain.plan;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.global.util.RepositoryUtil;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.travel.domain.travel.domain.plan.QTravelPlan.travelPlan;

@Repository
public class TravelPlanQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public TravelPlanQueryDslRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<TravelPlanDto> getList(TravelPlanDto travelPlanDto) {
        return queryFactory.select(Projections.fields(TravelPlanDto.class, travelPlan))
                .from(travelPlan)
                .where(
                        RepositoryUtil.equalsLong(travelPlanDto.getId(), travelPlan.id),
                        RepositoryUtil.equalsLong(travelPlanDto.getTravelId(), travelPlan.travelId),
                        RepositoryUtil.equals(travelPlanDto.getTravelDate(), travelPlan.travelDate),
                        RepositoryUtil.equals(travelPlanDto.getPlace(), travelPlan.place),
                        RepositoryUtil.equalsInt(travelPlanDto.getOrderNo(), travelPlan.orderNo))
                .fetch();
    }
}
