package com.travel.domain.travel.domain.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TravelPlanRepository  extends JpaRepository<TravelPlan, Long> {
    TravelPlan findTopByTravelIdAndTravelDateOrderByOrderNoDesc(Long travelId, String TravelDate);
    List<TravelPlan> findByTravelId(Long travelId);
    List<TravelPlan> findByTravelIdAndTravelDate(Long travelId, String travelDate);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    void deleteAllByTravelIdAndTravelDate(Long travelId, String TravelDate);

    Long countByTravelIdAndTravelDate(Long travelId, String travelDate);

}

