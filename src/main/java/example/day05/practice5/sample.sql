drop database if exists practice5;
create database practice5;
use practice5;

create table books(
	bno int primary key auto_increment,
    bwriter varchar(255),
    btitle varchar(255),
    bpublisher varchar(255)
);

insert into books( bwriter, btitle, bpublisher ) values( '유재석', '말을 잘하는 방법', '무한도전' );
insert into books( bwriter, btitle, bpublisher ) values( '박명수', '호통 잘치는 방법', '무모한 도전' );
insert into books( bwriter, btitle, bpublisher ) values( '하동훈', '잘 도망치는 방법', '런닝맨' );
select * from books;