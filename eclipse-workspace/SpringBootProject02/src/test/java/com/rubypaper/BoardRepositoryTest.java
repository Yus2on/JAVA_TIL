package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(4L);
	}
	
//	@Test
	public void testUpdateBoard() {
		// 수정할 엔티티를 검색한다. 검색을 해야 1차 캐시에 엔티티가 등록되고, 이 상태가 영속 상태다.
		Board board = boardRepo.findById(4L).get();
		board.setTitle("제목");
		// CrudRepository에 있는 save() 메소드는 merge() 메소드와 유사하다.
		boardRepo.save(board);
	}
	
//	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
//	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("Boot JPA 테스트");
		
		boardRepo.save(board);
	}
}










