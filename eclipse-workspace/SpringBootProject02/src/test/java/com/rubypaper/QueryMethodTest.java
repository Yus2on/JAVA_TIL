//package com.rubypaper;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.rubypaper.domain.Board;
//import com.rubypaper.persistence.BoardRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class QueryMethodTest {
//
//	@Autowired
//	private BoardRepository boardRepo;
//	
////	@Before
//	public void dataPrepare() {
//		for (int i = 1; i <= 200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 : " + i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testFindByTitleContaining() {
//		// page 번호는 0부터 시작한다. 따라서 1페이지를 보고싶으면 0
//		// size 몇 건의 데이터를 가져올 것인지 지정한다.
//		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("17", pageable);
//		
//		System.out.println("PAGE SIZE : " + pageInfo.getSize());
//		System.out.println("Total PAGES : " + pageInfo.getTotalPages());
//		System.out.println("Total COUNT : " + pageInfo.getTotalElements());
//		System.out.println("NEXT PAGE : " + pageInfo.nextPageable());
//		
//		List<Board> boardList = pageInfo.getContent();
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
//	
////	@Test
//	public void testFindByContentContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByContentContainingOrderBySeqDesc("17");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
//	
////	@Test
//	public void testFindByTitleContainingContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("15", "17");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
//	
////	@Test
//	public void testFindByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
//	
////	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 : 10");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
