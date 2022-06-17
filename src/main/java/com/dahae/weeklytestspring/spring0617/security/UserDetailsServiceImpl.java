package com.dahae.weeklytestspring.spring0617.security;

import com.dahae.weeklytestspring.spring0617.model.User;
import com.dahae.weeklytestspring.spring0617.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationNotSupportedException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            try {
                throw new AuthenticationCredentialsNotFoundException("아이디 또는 비밀번호가 맞지 않습니다.");
            } catch (AuthenticationCredentialsNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new UserDetailsImpl(user.get());
    }
}
