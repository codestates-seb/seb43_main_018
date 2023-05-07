package com.codestates.TrashCan;

import com.codestates.Vote.VoteDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrashCanDto {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String location;
    private String canType;
    private int likeCount;
    private int dislikeCount;
    private List<VoteDto> votes;


}

