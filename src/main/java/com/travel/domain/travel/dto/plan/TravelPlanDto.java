package com.travel.domain.travel.dto.plan;

import com.travel.domain.travel.domain.plan.TravelPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelPlanDto {
    private Long id;
    private Long travelId;
    private String travelDate;
    private String place;
    private int orderNo;

    @Builder
    public TravelPlanDto(Long id, Long travelId, String travelDate, String place, int orderNo) {
        this.id = id;
        this.travelId = travelId;
        this.travelDate = travelDate;
        this.place = place;
        this.orderNo = orderNo;
    }

    public static TravelPlanDto of(TravelPlan travelPlan) {
        return new TravelPlanDto(
                travelPlan.getId(),
                travelPlan.getTravelId(),
                travelPlan.getTravelDate(),
                travelPlan.getPlace(),
                travelPlan.getOrderNo());
    }
}
