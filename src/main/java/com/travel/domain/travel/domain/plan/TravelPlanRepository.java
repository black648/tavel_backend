package com.travel.domain.travel.domain.plan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPlanRepository  extends JpaRepository<TravelPlan, Long> {
    TravelPlan findTopByTravelIdAndTravelDateOrderByOrderNoDesc(Long travelId, String TravelDate);

    void deleteAllByTravelIdAndTravelDate(Long travelId, String TravelDate);

}

