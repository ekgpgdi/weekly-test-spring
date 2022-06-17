package com.dahae.weeklytestspring.spring0617.model;

import com.dahae.weeklytestspring.spring0617.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private String role;

    public User(UserDto userDto, String role) {
        this.email = userDto.getEmail();
        this.name = userDto.getName();
        this.age = userDto.getAge();
        this.gender = userDto.getGender();
        this.role = role;
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.age = userDto.getAge();
        this.gender = userDto.getGender();
    }
}
