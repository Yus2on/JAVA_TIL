package com.rubypaper;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Before
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("둘리");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("도우너");
		memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1); // 둘리가 등록한 게시 글
			board.setTitle("둘리가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
			boardRepo.save(board);
		}
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2); // 도우너가 등록한 게시 글
			board.setTitle("도우너가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
			boardRepo.save(board);
		}
	}
	
	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		System.out.println(board.getSeq() + "번 게시 글의 정보");
		System.out.println(board.getTitle());
		System.out.println(board.getCreateDate());
		System.out.println(board.getMember().getName());
		System.out.println(board.getMember().getId());
	}

}










