package com.metaverse.wildfirewatcher_2025.notice.domain;

import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import com.metaverse.wildfirewatcher_2025.comment.domain.Comment;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Table(name="notice")
@Entity
public class Notice extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private boolean important;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Notice(String title, String content, boolean important, User user) {
        this.title = title;
        this.content = content;
        this.important = important;
        this.user = user;
    }

    public void update(NoticeRequestDto noticeRequestDto){
        this.title = noticeRequestDto.getTitle();
        this.content = noticeRequestDto.getContent();
        this.important = noticeRequestDto.isImportant();
    }

}
