package com.dahae.weeklytestspring.spring0617.controller;

import com.dahae.weeklytestspring.spring0617.common.ApiResponse;
import com.dahae.weeklytestspring.spring0617.dto.LoginDto;
import com.dahae.weeklytestspring.spring0617.dto.ResponseDto;
import com.dahae.weeklytestspring.spring0617.dto.UserDto;
import com.dahae.weeklytestspring.spring0617.model.User;
import com.dahae.weeklytestspring.spring0617.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse createUser(@RequestBody UserDto requestDto) {
        return new ApiResponse(userService.join(requestDto, "User"), 201);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @GetMapping("/read/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.find(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody UserDto requestDto, @PathVariable Long id) {
        return userService.update(requestDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return id;
    }

    @GetMapping("/recommend/{id}")
    public ResponseDto recommendUser(@PathVariable Long id) {
        List<User> userList = userService.recommend(id);
        return new ResponseDto(userList);
    }
}
