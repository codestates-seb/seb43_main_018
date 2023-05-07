package com.codestates.TrashCan;

import com.codestates.Vote.Vote;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trash_cans")
@Getter
@Setter
public class TrashCan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("latitude")
    @Column(nullable = false)
    private Double latitude;

    @JsonProperty("longitude")
    @Column(nullable = false)
    private Double longitude;

    @JsonProperty("Full Address")
    @Column(nullable = false)
    private String location;

    @JsonProperty("종류")
    private String canType;

    @Column(nullable = false)
    private int likeCount;

    @Column(nullable = false)
    private int dislikeCount;

    @OneToMany(mappedBy = "trashCan", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();
}

