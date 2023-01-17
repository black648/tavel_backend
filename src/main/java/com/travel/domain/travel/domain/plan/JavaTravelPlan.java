//package com.travel.domain.travel.domain.plan;
//
//import com.travel.domain.travel.domain.JavaTravel;
//import com.travel.global.base.BaseEntity;
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table(name="travelPlan")
//public class JavaTravelPlan extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "travelId", insertable = false, updatable = false)
//    private JavaTravel travel;
//
//    @Column(name = "travelId")
//    private Long travelId;
//
//    @Column
//    private String travelDate;
//
//    @Column
//    private String place;
//
//    @Column
//    private int orderNo;
//
//    @Builder
//    public JavaTravelPlan(Long travelId, String travelDate, String place, int orderNo) {
//        this.travelId = travelId;
//        this.travelDate = travelDate;
//        this.place = place;
//        this.orderNo = orderNo;
//    }
//}
