package com.dahae.weeklytestspring.spring0617.service;

import com.dahae.weeklytestspring.spring0617.dto.LoginDto;
import com.dahae.weeklytestspring.spring0617.security.JwtProvider;
import com.dahae.weeklytestspring.spring0617.dto.UserDto;
import com.dahae.weeklytestspring.spring0617.model.User;
import com.dahae.weeklytestspring.spring0617.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public Long join(UserDto userDto, String role) {
        User user = new User(userDto, role);
        return userRepository.save(user).getId();
    }

    public User find(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    public User update(UserDto requestDto, Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        user.update(requestDto);
        return user;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> recommend(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        int gender = user.getGender() == 0 ? 1 : 0;
        return userRepository.findByAgeAndGender(user.getAge(), gender);
    }

    public String login(LoginDto loginDto) {
        return jwtProvider.createAccessToken(loginDto);
    }
}
