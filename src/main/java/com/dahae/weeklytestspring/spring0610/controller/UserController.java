package com.dahae.weeklytestspring.spring0610.controller;

import com.dahae.weeklytestspring.spring0610.dto.UserDto;
import com.dahae.weeklytestspring.spring0610.model.User;
import com.dahae.weeklytestspring.spring0610.service.UserService;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserDto requestDto) {
        return userService.join(requestDto);
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
    public String recommendUser(@PathVariable Long id) {
        List<User> userList = userService.recommend(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", userList);
        return jsonObject.toString();
    }
}
