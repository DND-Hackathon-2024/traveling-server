package com.plass.traveling.domain.place.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        장소 이름
    */
    @Column(nullable = false)
    private String placeName;

    /*
        장소 설명
    */
    @Column(nullable = false)
    private String placeDesc;

    /*
        장소 주소
    */
    @Column(nullable = false)
    private String address;

    /*
        카운트
    */
    @Column(nullable = false)
    private String count;
}
