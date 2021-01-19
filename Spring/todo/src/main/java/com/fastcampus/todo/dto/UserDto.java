package com.fastcampus.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    // Data Transfer Object 데이터전달객체 -> 전달에 더 중점을 둠
    // VO: Value Object -> 값객체, 값에 더 중점을 가지고 있음

    // DTO -> 계층(Layer) 간에 전달
    // Effective Java -> 파라미터 갯수 최소화

    // Json 을 만들기 위함
    // Presentation Layer.view -> pre'.Controller에 데이터 전달

    @NotEmpty // null == str && "" == str
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String city;
    @NotEmpty
    private String province;
    @NotEmpty
    private String password;
}
