package com.travel.domain.travel.dto.plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TravelPlanUpdateDto {
    private Long travelId;
    private String place;
    private int orderNo;
    private String beforeDate;
    private String afterDate;
    private String travelDate;

    @Builder
    public TravelPlanUpdateDto(Long travelId, String place, int orderNo, String beforeDate, String afterDate, String travelDate) {
        this.travelId = travelId;
        this.place = place;
        this.orderNo = orderNo;
        this.beforeDate = beforeDate;
        this.afterDate = afterDate;
        this.travelDate = travelDate;
    }
}
