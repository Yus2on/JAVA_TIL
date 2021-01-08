package com.fastcampus.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity     // hibernate -> (EntityManager)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    private String address;
    private String password;
    private String bloodType;
    // json / http : blood_type,
    // java, json, url : bloodType, blood-type

    // @OneToOne
    // @OneToMany
    // @ManyToOne
    // @ManyToMany

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @ToString.Exclude
    private Todo todo; // inner join User x Todo

    public static User emptyObject() {
        return new User();
    }
}