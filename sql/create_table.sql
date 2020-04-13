# root로 접속
# sudo mysql -uroot -p
create schema jdbc;
grant all on jdbc.* to jdbc@localhost identified by 'javaprogramming';
quit

# 위에서 만든 사용자로 접속
# mysql -ujdbc -p
use jdbc

# p.849 <표 16-1> 테이블 생성
create table student (
	id int primary key auto_increment,
	name varchar(20),
	dept varchar(20)
);

# p.852 <표 16-2> 데이터 입력 
insert student(name, dept)
values ('김철수', '컴퓨터시스템'),
	('최고봉', '멀티미디어'),
	('이기자', '컴퓨터공학' );
