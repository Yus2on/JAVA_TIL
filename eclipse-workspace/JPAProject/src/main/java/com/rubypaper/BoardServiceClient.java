package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class BoardServiceClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// 비영속 상태의 엔티티 객체
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("테스터");
			board.setContent("JPA 내용........");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글 등록 처리
			// tx 시작
			tx.begin();
			em.persist(board);
			
			em.remove(board);


			// tx 종료
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}





