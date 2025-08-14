package com.metaverse.wildfirewatcher_2025.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="notice")
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int user_id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private boolean is_important;
}
