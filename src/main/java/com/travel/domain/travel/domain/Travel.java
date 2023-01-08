package com.travel.domain.travel.domain;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.domain.travel.dto.TravelUpdateDto;
import com.travel.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="travel")
public class Travel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<TravelPlan> travelPlanList = new ArrayList<>();

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<TravelCity> travelCityList = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String userId;

    @Column
    private String travelStartDate;

    @Column
    private String travelEndDate;

    @Builder
    public Travel(Long id, String name, String userId, String travelStartDate, String travelEndDate) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.travelStartDate = travelStartDate;
        this.travelEndDate = travelEndDate;
    }

    public void update(TravelUpdateDto travelUpdateDto) {
        this.name = travelUpdateDto.getName();
        this.travelStartDate = travelUpdateDto.getTravelStartDate();
        this.travelEndDate = travelUpdateDto.getTravelEndDate();
    }
}
