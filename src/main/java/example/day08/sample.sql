drop database if exists mydb0311;
create database mydb0311;
use mydb0311;

INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("자바공부하기", "Chapter 5 상속과 다형성", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("SQLD 자격증", "기출문제 1회분 풀기", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("운동하기", "스쿼트 및 하체 루틴", true, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("블로그 포스팅", "디자인 패턴 정리", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("프로젝트 검토", "Hwaturo 덱 생성 로직", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("방 청소", "책상 정리 및 분리수거", true, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("알고리즘", "백준 실버 문제 2개", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("독서", "클린 코드 1장", false, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("장보기", "우유, 계란, 닭가슴살", true, NOW(), NOW());
INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("영단어", "토익 단어 50개", false, NOW(), NOW());