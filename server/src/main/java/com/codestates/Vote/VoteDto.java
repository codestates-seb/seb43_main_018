package com.codestates.Vote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDto {

    private Long id;
    private Long trashCanId;
    private Boolean isLike;
    private String memberId;

}
