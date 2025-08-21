package com.metaverse.wildfirewatcher_2025.auth.service;

import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import com.metaverse.wildfirewatcher_2025.auth.dto.UserRequestDto;
import com.metaverse.wildfirewatcher_2025.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    //로그인 회원가입(존재 여부)
    @Transactional(readOnly = true)
    public boolean existUser(UserRequestDto dto){
        return userRepository.existsByUsername(dto.getUsername());
    }

    //로그인 회원가입
//    @Transactional
//    public Long addUser(UserRequestDto dto){
//        if (userRepository.existsByUsername(dto.getUsername())) {
//            throw new IllegalArgumentException("username is already taken");
//        }
//
//        User user = User.builder()
//                .username(dto.getUsername())
//                .password(passwordEncoder.encode(dto.getPassword()))
//                .phone_number(dto.getPhone_number())
//                .email(dto.getEmail())
//                .build();
//    }
    //로그인

    //로그인 회원정보 수정

    //로그인 회원 탈퇴

    //유저 정보 조회
}
