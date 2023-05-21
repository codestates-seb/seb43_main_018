package com.codestates.domain.board.dto;

import com.codestates.domain.comment.dto.CommentDto;
import com.codestates.domain.member.entity.Member;
import com.codestates.domain.plogging.comment.dto.PlogCommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public class BoardDto {
	@Getter
	@Setter
	@AllArgsConstructor
	public static class Post {
		@NotBlank(message = "b_title not null")
		private String b_title;
		@NotBlank(message = "b_content not null")
		private String b_content;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	public static class Patch {
		private long b_id;
		@NotBlank(message = "b_title not null")
		private String b_title;
		@NotBlank(message = "b_content not null")
		private String b_content;
	}

	@Getter
	@AllArgsConstructor
	public static class Response {
		private long b_id;
		private String b_title;
		private String b_content;
		private long likes;
		private long memberId;
		private String username;
		private LocalDateTime createdAt;
		private LocalDateTime modifiedAt;
		private boolean checkLike;
		public void setMember(Member member){this.memberId= member.getMemberId();}
	}

	@Getter
	@Setter
	@AllArgsConstructor
	public static class Detail {
		private long b_id;
		private String b_title;
		private String b_content;
		private long likes;
		private long memberId;
		private String username;
		private LocalDateTime createdAt;
		private LocalDateTime modifiedAt;

		private boolean checkLike;
		public void setMember(Member member){this.memberId= member.getMemberId();}
		private List<CommentDto.Response> comments;
	}
}
