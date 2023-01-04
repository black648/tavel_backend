package com.travel.domain.city.domain;

import com.travel.domain.city.dto.request.CityUpdateRequestDto;
import com.travel.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="city")
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private CityCategory category;

    @Builder
    public City(String name, CityCategory category) {
        this.name = name;
        this.category = category;
    }

    public void update(CityUpdateRequestDto requestDto) {
        this.name = requestDto.getName();
        this.category = requestDto.getCategory();
    }

}
