package com.dahae.weeklytestspring.spring0610.service;

import com.dahae.weeklytestspring.spring0610.dto.UserDto;
import com.dahae.weeklytestspring.spring0610.model.User;
import com.dahae.weeklytestspring.spring0610.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public User join(UserDto userDto){
        User user = new User(userDto);
        return userRepository.save(user);
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
}
