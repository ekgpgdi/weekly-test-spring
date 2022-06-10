package com.dahae.weeklytestspring.spring0610.model;

import com.dahae.weeklytestspring.spring0610.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="users")
public class User extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    int gender;

    public User(UserDto userDto) {
        this.email = userDto.getEmail();
        this.name = userDto.getName();
        this.age = userDto.getAge();
        this.gender = userDto.getGender();
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.age = userDto.getAge();
        this.gender = userDto.getGender();
    }
}
