package com.codestates.domain.vote;

import com.codestates.domain.member.entity.Member;
import com.codestates.domain.trashcan.TrashCan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class VoteDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CreateRequest {
        private Long trashCanId;
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
        private LocalDateTime modifiedAt;

        public void setMember(Member member){this.memberId= member.getMemberId();}
        public void setTrashCan(TrashCan trashCan){this.trashCanId = trashCan.getId();}
    }

    public enum VoteTypeEnum {
        LIKE, DISLIKE
    }
}

