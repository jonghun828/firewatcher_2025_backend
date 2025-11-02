package com.metaverse.wildfirewatcher_2025.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentResponseDto;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDto extends TimeStamped {
    private Long id;
    private String user_name;
    private String author;
    private String title;
    private String content;
    private boolean important;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    private List<CommentResponseDto> comments;

    public NoticeResponseDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.important = notice.isImportant();
        this.createdAt = notice.getCreatedAt();
        this.modifiedAt = notice.getModifiedAt();

        if(notice.getUser() != null) {
            this.user_name = notice.getUser().getUsername();
            this.author = notice.getUser().getAuthor();
        }

        if (notice.getComments() != null) {
            this.comments = notice.getComments().stream()
                    .map(CommentResponseDto::new)
                    .collect(Collectors.toList());
        } else {
            this.comments = List.of();
            }
        }
}
