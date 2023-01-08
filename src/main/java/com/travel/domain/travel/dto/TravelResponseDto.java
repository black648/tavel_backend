package com.travel.domain.travel.dto;

import com.travel.domain.travel.domain.Travel;
import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.plan.TravelPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class TravelResponseDto {
    private Long id;
    private String name;
    private String userId;
    private String travelStartDate;
    private String travelEndDate;
    private List<TravelPlan> travelPlanList = new ArrayList<>();
    private List<TravelCity> travelCityList = new ArrayList<>();

    @Builder
    public TravelResponseDto(Travel travel) {
        this.id = travel.getId();
        this.name = travel.getName();
        this.userId = travel.getUserId();
        this.travelStartDate = travel.getTravelStartDate();
        this.travelEndDate = travel.getTravelEndDate();
        this.travelPlanList = travel.getTravelPlanList();
        this.travelCityList = travel.getTravelCityList();
    }
}
