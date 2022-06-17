package com.dahae.weeklytestspring.spring0617.dto;

import com.dahae.weeklytestspring.spring0617.model.User;
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
