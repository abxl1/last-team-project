package com.example.lastproject.domain.user.controller;

import com.example.lastproject.domain.auth.entity.AuthUser;
import com.example.lastproject.domain.user.dto.UserUpdateRequest;
import com.example.lastproject.domain.user.dto.request.UserChangePasswordRequest;
import com.example.lastproject.domain.user.dto.response.UserResponse;
import com.example.lastproject.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 사용자 단건 조회
     *
     * @param userId 사용자 id
     * @return 응답 객체 반환 ( email, nickname, successCode )
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId) {
        UserResponse response = userService.getUser(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * 비밀번호 변경
     *
     * @param authUser 인증된 사용자
     * @param request  비밀번호 변경에 필요한 정보 ( 기존 비밀번호, 새 비밀번호 )
     * @return 응답 객체 반환 ( email, nickname, successCode )
     */
    @PutMapping("/users/password")
    public ResponseEntity<UserResponse> changePassword(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestBody UserChangePasswordRequest request) {
        UserResponse response = userService.changePassword(authUser.getUserId(), request);
        return ResponseEntity.ok(response);
    }

    /**
     * 사용자 정보 변경
     *
     * @param authUser 인증된 사용자
     * @param request  변경에 필요한 정보 ( 이메일, 닉네임, 주소 )
     * @return 응답 객체 반환 ( email, nickname, successCode )
     */
    @PutMapping("/users")
    public ResponseEntity<UserResponse> updateUser(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestBody UserUpdateRequest request
    ) {
        UserResponse response = userService.updateUser(authUser.getUserId(), request);
        return ResponseEntity.ok(response);
    }
}
