package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.model.Address;
import com.fastcampus.todo.model.Todo;
import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.TodoRepository;
import com.fastcampus.todo.repository.UserRepository;
import com.fastcampus.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final UserService userService;

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElse(User.emptyObject());
    }

    // 꼭 필요한 필수값이면서 판별값이 아니라면 리퀘스트파람으로 넣음 아니면 패스트베리어블
    @GetMapping("/api/user")        // localhost:8070/api/user?email=martin@fastcampus.com
    public List<User> getUserByEmail(@RequestParam @NotEmpty String email) {
        return userService.getUsersByEmail(email);
    }

    @PostMapping("/api/user")
    public void postUser(@RequestBody @Valid UserDto userDto) {
        User user = new User(
                null,
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                "",
                new Address("seoul", "seongdong-gu"),
                false,
                new Todo());

        userRepository.save(user);      // Spring Data Jpa
        // Hibernate EntityManager.persist();
//        User user1 = userRepository.findById(1L).get();
//        System.out.println(">>> user1 : " + user1);

//        userRepository.delete(user1);
//        user1.setTodo(null);
//        todoRepository.deleteById(1L);
//        userRepository.saveAndFlush(user1);
//        System.out.println(">>> user1 after null : " + user1);

//        System.out.println(">>> todo1 : " + todoRepository.findById(1L).get());

        System.out.println(">>>> " + userRepository.findById(1L).get());

        System.out.println(">>>> queryMethod : " + userRepository.findByEmail("martin@fastcampus.com"));

        System.out.println(">>>> @Query : " + userRepository.findByMailAndBloodType("martin@fastcampus.com", "A"));
        // 저장
    }

    @PostMapping("/api/upload")
    public void uploadFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("파일이름");

//        if (multipartFile != null) {
//            try (InputStream is = multipartFile.getInputStream()) {
//                // for (is)
//            } catch (Exception e) {
//
//            }
//        }
    }

}