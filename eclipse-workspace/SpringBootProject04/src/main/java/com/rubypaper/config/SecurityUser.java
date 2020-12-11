package com.rubypaper.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.domain.Member;

public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Member member) {
		// 아이디, 비밀번호(암호화하지 않은), 권한을 부모 생성자쪽에 전달한다.
		super(member.getId(), 
		     member.getPassword(), 
		     AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
