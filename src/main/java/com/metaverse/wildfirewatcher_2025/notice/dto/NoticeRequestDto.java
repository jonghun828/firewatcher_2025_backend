package com.metaverse.wildfirewatcher_2025.notice.dto;

import lombok.Getter;

@Getter
public class NoticeRequestDto {
    private String title;
    private String content;
    private boolean important;
}
