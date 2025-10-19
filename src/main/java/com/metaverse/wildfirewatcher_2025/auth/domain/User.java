package com.metaverse.wildfirewatcher_2025.auth.domain;

import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone_number;

    @Column(nullable = false)
    private int zone_id;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Notice> notices =  new ArrayList<>();

    public User(String username, String author, String password, String email, UserRole userRole, String phone_number, int zone_id) {
        this.username = username;
        this.author = author;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.phone_number = phone_number;
        this.zone_id = zone_id;
    }

    public User(String username, String author, String password, String email, UserRole userRole) {
        this.username = username;
        this.author = author;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }
}
