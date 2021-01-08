package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    // 문제점
    //  - 메서드 이름으로만 했더니 지저분해짐
    //  - 커스텀하게 쓸 수 있는 방법은 두 개
    //      1. 쿼리 어노테이션을 달고 쿼리를 만드는 것 (@Query)
    //      2. 다른 라이브러리 사용 (3rd-party library : QueryDsl, Jooq, ...)
    // User findByEmailAndNameAndBloodTypeAndAddressAndPassword(String email, String name, String bloodType, String address, String password);

    // 스트링 넣으면 쿼리 만들어주는데 두종류가 잇음
    //  1. native query : 데이터베이스에서 조회하는 쿼리. 기본이 false.
    //  2. jpql
    // email = ?1 ---> 첫번째 파라미터, ?2 ----> 두번째 파라미터
    //      - 근데 순서를 따지는 건 안티패턴임. 하나 수정되면 다 뜯어고쳐야 함
    //      - 그래서 네임을 사용하는 게 좋다
    // 뒤에 order by 도 추가 가능
    // 네이티브 쿼리도 복잡해지지만 메서드명으로만 하는 것보단 이게 나음 -> QueryDsl을 쓰지 않고 간단하게 쓰는 정도
    @Query("select u from User u where u.email = :mail and u.bloodType = :bloodType")
    List<User> findByMailAndBloodType(@Param("mail") String mail, @Param("bloodType") String bloodType);

    // User -> Blog_User -> Blog_Post
    // findById() -> User.getBlogUser().getBlogPost();

}