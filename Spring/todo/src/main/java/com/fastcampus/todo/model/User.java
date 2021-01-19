package com.fastcampus.todo.model;

import com.fastcampus.todo.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity     // hibernate -> (EntityManager)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Where(clause = "deleted = false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "email")
    private String email;
//    private String address;
    private String password;
    private String bloodType;
    // json / http : blood_type,
    // java, json, url : bloodType, blood-type

    @Embedded
    private Address address;

    @ColumnDefault("false")
    private boolean deleted;    // primitive, 기본값 : false

    // @OneToOne
    // @OneToMany
    // @ManyToOne
    // @ManyToMany

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)   // 컬럼명: todo_id
    @ToString.Exclude
    // @JsonIgnore
    private Todo todo;      // inner join User x Todo

    public static User emptyObject() {
        return new User();
    }

    public static User of(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(new Address(userDto.getCity(), userDto.getProvince()));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }
}