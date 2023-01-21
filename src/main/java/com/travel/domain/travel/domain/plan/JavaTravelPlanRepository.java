//package com.travel.domain.travel.domain.plan;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//
//import java.util.List;
//
//public interface JavaTravelPlanRepository extends JpaRepository<JavaTravelPlan, Long> {
//    JavaTravelPlan findTopByTravelIdAndTravelDateOrderByOrderNoDesc(Long travelId, String TravelDate);
//    List<JavaTravelPlan> findByTravelId(Long travelId);
//    List<JavaTravelPlan> findByTravelIdAndTravelDate(Long travelId, String travelDate);
//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    void deleteAllByTravelIdAndTravelDate(Long travelId, String TravelDate);
//
//    Long countByTravelIdAndTravelDate(Long travelId, String travelDate);
//
//}
//
