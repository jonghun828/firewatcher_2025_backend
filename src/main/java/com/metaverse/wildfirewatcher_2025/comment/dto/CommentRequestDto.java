package com.metaverse.wildfirewatcher_2025.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String content;
    private Long parentCommentId;
}
