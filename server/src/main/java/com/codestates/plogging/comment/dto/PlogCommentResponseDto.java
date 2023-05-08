package com. codestates.plogging.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PlogCommentResponseDto {
    private long memberId;
    private long plogId;
    private String plogComment;
    private String memberName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
