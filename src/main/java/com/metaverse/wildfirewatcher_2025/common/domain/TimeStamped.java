package com.metaverse.wildfirewatcher_2025.common.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeStamped {
    @CreatedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modifiedAt;
}
