package com.metaverse.wildfirewatcher_2025.auth.repository;

import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);
}
