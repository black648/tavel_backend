package com.travel.domain.travel.domain;

import com.travel.domain.travel.domain.city.TravelCity;
import com.travel.domain.travel.domain.plan.TravelPlan;
import com.travel.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime travelStartDate;

    @Column
    private LocalDateTime travelEndDate;
}
