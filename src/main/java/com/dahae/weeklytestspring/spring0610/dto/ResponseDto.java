package com.dahae.weeklytestspring.spring0610.dto;

import com.dahae.weeklytestspring.spring0610.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private List<User> result;
}
