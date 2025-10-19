package com.metaverse.wildfirewatcher_2025.comment.domain;

import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name="comment")
@Entity
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(length = 1000, nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> childComments = new ArrayList<>();

    public Comment(String content, Notice notice, User user) {
        this.content = content;
        this.notice = notice;
        this.parentComment = null;
        this.user = user;
    }

    public Comment(String content, Notice notice, Comment parentComment, User user) {
        if (parentComment == null) {
            throw new IllegalArgumentException("부모 댓글은 null이 될 수 없습니다. 최상위 댓글은 다른 생성자를 사용하세요.");
        }
        if (!notice.getId().equals(parentComment.getNotice().getId())) {
            throw new IllegalArgumentException("대댓글은 부모 댓글과 동일한 게시글에 속해야 합니다.");
        }
        this.content = content;
        this.notice = notice;
        this.parentComment = parentComment;
        this.user = user;
    }

    public void update(String content) {
        this.content = content;
    }

    public boolean isTopLevelComment() {
        return this.parentComment == null;
    }

}
