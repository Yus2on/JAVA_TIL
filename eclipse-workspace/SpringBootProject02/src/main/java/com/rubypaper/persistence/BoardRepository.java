package com.rubypaper.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;
import java.lang.String;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
/*	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByContentContainingOrderBySeqDesc(String searchKeyword);
	
//	List<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	// @Query 어노테이션을 이용한 JPQL 등록 
	// JPQL은 검색 대상이 테이블이 아니라 영속 상태에 있는 엔티티 객체들이다. 
	// 그리고 컬럼이 사용되는 것이 아니라 엔티티 객체의 변수가 사용된다. (SELECT, WHERE, ORDER BY, GROUP BY) 
	@Query("SELECT b FROM Board b WHERE b.title like %:keyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("keyword") String keyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %:keyword% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("keyword") String keyword);

	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest3(Pageable pageable);*/
}










