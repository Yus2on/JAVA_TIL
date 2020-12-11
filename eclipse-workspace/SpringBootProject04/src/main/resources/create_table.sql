drop table member;

create table member(
	id varchar2(10) primary key,
	password varchar2(100),
	name varchar2(30),
	role varchar2(12),
	enabled boolean
);

insert into member values('member', 'member123', '회원', 'ROLE_MEMBER', true);
insert into member values('manager', 'manager123', '매니저', 'ROLE_MANAGER', true);
insert into member values('admin', 'admin123', '어드민', 'ROLE_ADMIN', true);
