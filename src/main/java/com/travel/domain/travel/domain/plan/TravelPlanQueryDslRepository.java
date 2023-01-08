package com.travel.domain.travel.domain.plan;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.travel.domain.travel.dto.plan.TravelPlanDto;
import com.travel.domain.travel.dto.plan.TravelPlanUpdateDto;
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

    public Long updateTravelDate(TravelPlanUpdateDto updateDto) {
        return queryFactory.update(travelPlan)
                .where(travelPlan.travelId.eq(updateDto.getTravelId()),
                       travelPlan.travelDate.between(updateDto.getBeforeDate(), updateDto.getAfterDate()))
                .set(travelPlan.travelDate, updateDto.getTravelDate())
                .execute();
    }

    public Long updateOrder(Long travelId, String travelDate, Long addCount) {
        return queryFactory.update(travelPlan)
                .where(travelPlan.travelId.eq(travelId), travelPlan.travelDate.eq(travelDate))
                .set(travelPlan.orderNo, travelPlan.orderNo.add(addCount))
                .execute();
    }

    public void deleteAllToTravelId(Long travelId) {
        queryFactory.delete(travelPlan).where(travelPlan.travelId.eq(travelId)).execute();
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
