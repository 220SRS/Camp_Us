package com.campus.campus.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {

        @NotBlank
        private String name;

        @NotBlank
        private String email;

        @NotBlank
        private String phone;

        @NotBlank
        private String password;

        @NotBlank
        private String confirmPassword;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long memberId;
        private String name;
        private String nickName;
        private String email;
        private String phone;
    }
}
