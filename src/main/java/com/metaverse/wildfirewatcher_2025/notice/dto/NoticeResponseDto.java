package com.metaverse.wildfirewatcher_2025.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentResponseDto;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class NoticeResponseDto extends TimeStamped {
    private Long id;
    private String title;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedAt;

    private List<CommentResponseDto> comments;

public NoticeResponseDto(Notice notice) {
    this.id = notice.getId();
    this.title = notice.getTitle();
    this.content = notice.getContent();
    this.createAt =notice.getCreatedAt();
    this.modifiedAt = notice.getModifiedAt();


}

}
