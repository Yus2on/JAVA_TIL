package com.rubypaper.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepo;

	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// MemberRepository 객체를 이용하여 Member 정보를 조회한다. 
		Optional<Member> findMember = memberRepo.findById(username);
		if(!findMember.isPresent()) {
			// 검색 결과가 없다면...
			throw new UsernameNotFoundException(username + "사용자가 없네요.");
		} else {
			Member member = findMember.get();
			return new SecurityUser(member);
		}
	}

}








