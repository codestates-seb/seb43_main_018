package com.codestates.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class CommentDto {
	@Getter
	public static class Post {
		@NotBlank(message = "내용은 공백이 아니어야 합니다.")
		private String c_content;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	public static class Patch {
		@NotBlank(message = "c_id는 공백이 아니어야 합니다.")
		private long c_id;
		@NotBlank(message = "내용은 공백이 아니어야 합니다.")
		private String c_content;
	}

	@Getter
	@AllArgsConstructor
	public static class Response {
		private long c_id;
		private String c_content;
	}
}
