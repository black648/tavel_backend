package com.travel.domain.travel.domain.plan;

import com.travel.domain.travel.domain.Travel;
import com.travel.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="travelPlan")
public class TravelPlan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Travel travel;

    @Column
    private String travelDate;

    @Column
    private String place;

    @Column
    private int orderNo;

}
