package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private BoardUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 사이트간 요청 위조를 비활성화 시킨다.
		security.csrf().disable();
		
		// SecurityController에 등록된 요청에 대해서 인증과 권한을 체크한다.
		// index(/) 페이지는 인증에 상관없이 모든 사용자가 요청할 수 있다. 
		security.authorizeRequests().antMatchers("/").permitAll();
		// member 경로에 있는 파일에 대한 요청은 인증된, 즉 로그인 성공한 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		// manager 경로에 있는 파일에 대한 요청은 인증에 성공했고 권한이 MANAGER인 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		// admin 경로에 있는 파일에 대한 요청은 인증에 성공했고 권한이 MANAGER인 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		// 사용자에게 로그인 화면을 제공한다.
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		// 권한이 없는 페이지에 접근했을 때 보여줄 화면을 지정한다. 
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		
		// 로그아웃(/logout) 요청이 들어왔을 때, 세션을 강제로 종료하고 로그인 화면으로 이동하도록 설정한다.
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		// 앞에서 작성한 BoardUserDetailsService 객체를 
		// 시큐리티가 인지하도록 UserDetailsService 객체로 등록한다. 
		security.userDetailsService(userDetailsService);
		
	}
	
	// 스프링 컨테이너는 메소드 위에 @Autowried를 설정하면 메소드가 호출될 때
	// 매개변수에 해당하는 객체를 의존성 주입한다.
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
///*		auth.inMemoryAuthentication().
//		withUser("manager").
//		password("{noop}manager111").
//		roles("MANAGER");
//		
//		auth.inMemoryAuthentication().
//		withUser("admin").
//		password("{noop}admin111").
//		roles("ADMIN");*/
//		
//		// 특정 아이디에 해당하는 회원 정보가 있는지 검색한다. ({noop} 접두사를 문자열 앞에 붙이면 암호화 작업을 하지 않는다.)
//		String query1 = "select id as username, concat('{noop}', password) as password, "
//				+ "enabled from member where id=?";
//		// 특정 회원의 권한을 검색한다.
//		String query2 = "select id, role from member where id=?";
//		auth.jdbcAuthentication().
//		dataSource(dataSource).
//		usersByUsernameQuery(query1).
//		authoritiesByUsernameQuery(query2);
//	}
}










