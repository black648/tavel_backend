package com.travel.domain.travel.domain;

import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.domain.travel.dto.TravelDto;
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
    private final List<TravelPlan> travelPlans = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String userId;

    @Column
    private String travelStartDate;

    @Column
    private String travelEndDate;

    @Builder
    public Travel(String name, String userId, String travelStartDate, String travelEndDate) {
        this.name = name;
        this.userId = userId;
        this.travelStartDate = travelStartDate;
        this.travelEndDate = travelEndDate;
    }

    public void update(TravelDto travelDto) {
        this.name = travelDto.getName();
        this.userId = travelDto.getUserId();
        this.travelStartDate = travelDto.getTravelStartDate();
        this.travelEndDate = travelDto.getTravelEndDate();
    }
}
