package com.metaverse.wildfirewatcher_2025.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.comment.domain.Comment;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto extends TimeStamped {
    private Long id;
    private String content;
    private String author;
    private String user_name;
    private Long notice_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();

        if (comment.getNotice() != null) {
            this.notice_id = comment.getNotice().getId();
        } else {
            this.notice_id = null;
        }

        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();

        if(comment.getUser() != null) {
            this.user_name = comment.getUser().getUsername();
            this.author = comment.getUser().getAuthor();
        }
    }
}
