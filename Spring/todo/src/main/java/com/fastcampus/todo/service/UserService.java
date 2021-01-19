package com.fastcampus.todo.service;

import com.fastcampus.todo.aop.CustomLog;
import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.exception.EmailRequiredException;
import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.TodoRepository;
import com.fastcampus.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // -> DB: master / slave(primary / secondary, master branch -> main)
public class UserService { // <- class name: 명사
    private final UserRepository userRepository; // Object Name: 명사
    private final TodoRepository todoRepository;

    @CustomLog
    public List<User> getUsersByEmail(String email) { // method Name: 동사
        if (!StringUtils.hasText(email)) {
            throw new EmailRequiredException("email은 필수값입니다");
        }

        List<User> users = userRepository.findByEmail(email);   // Null-Safe

        if (users.isEmpty()) {
            users.add(new User("admin@fastcampus.com"));
        }

        return users;
    }
    // cleancode, refactoring -> 메소드의 line이 5줄 넘으면 메소드를 나눠라
    // -> method 10 line over -> 수정필요함

    @Transactional
    public void modifyUser(User user) {
        user.setBloodType("A");

        userRepository.save(user);
    }

    @Transactional
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void addUser(UserDto userDto) {
        userRepository.save(User.of(userDto));
    }
}