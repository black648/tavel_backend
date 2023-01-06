package com.travel.domain.travel.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelCityRepository extends JpaRepository<TravelCity, Long> {
    List<TravelCity> findByTravelId(Long travelId);
    List<TravelCity> findByCityId(Long cityId);
}
