package com.dahae.weeklytestspring.spring0617.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private  final String email;
    private  final String name;
    private  final int age;
    private  final int gender;
}
