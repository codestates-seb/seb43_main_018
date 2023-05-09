package com.codestates.Maker;

import com.codestates.audit.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "makers")
@JsonIgnoreProperties({"ID","소재지도로명","소재지도로명주소","설치장소유형","수거쓰레기종류","관리기관명","관리기관전화번호","데이터기준일자","상세위치"})
public class Makers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ID")
    private Long id;

    @JsonProperty("위도")
    private double longitude;

    @JsonProperty("경도")
    private double latitude;

    @JsonProperty("소재지지번주소")
    private String addressGu;

    @JsonProperty("쓰레기통형태")
    private String containerType;

}
