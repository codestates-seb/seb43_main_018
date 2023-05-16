package com.codestates.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VoteDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CreateRequest {
        @NotNull(message = "memberId는 공백이 아니어야 합니다.")
        private Long memberId;
        @NotBlank(message = "trashCanId는 공백이 아니어야 합니다.")
        private Long trashCanId;
        @NotBlank(message = "voteType은 공백이 아니어야 합니다.")
        private VoteTypeEnum voteType;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private Long memberId;
        private Long trashCanId;
        private VoteTypeEnum voteType;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    public enum VoteTypeEnum {
        LIKE, DISLIKE
    }
}

