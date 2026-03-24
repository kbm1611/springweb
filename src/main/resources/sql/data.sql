
-- resources -> sql -> data.sql 파일
-- ------- day08 todo sample insert -------
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("자바공부하기", "Chapter 5 상속과 다형성", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("SQLD 자격증", "기출문제 1회분 풀기", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("운동하기", "스쿼트 및 하체 루틴", true, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("블로그 포스팅", "디자인 패턴 정리", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("프로젝트 검토", "Hwaturo 덱 생성 로직", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("방 청소", "책상 정리 및 분리수거", true, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("알고리즘", "백준 실버 문제 2개", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("독서", "클린 코드 1장", false, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("장보기", "우유, 계란, 닭가슴살", true, NOW(), NOW());
-- INSERT INTO todo(title, content, done, create_date, update_date) VALUES ("영단어", "토익 단어 50개", false, NOW(), NOW());

-- 1개만 제대로 만들고 AI에게 100개 200개 만들어달라고 하기

-- ---------------- day11 todo sample insert ----------------
# insert into category (cname, create_date, update_date) values ('공부', now(), now());
# insert into category (cname, create_date, update_date) values ('운동', now(), now());
# insert into category (cname, create_date, update_date) values ('업무', now(), now());
# insert into category (cname, create_date, update_date) values ('취미', now(), now());
# insert into category (cname, create_date, update_date) values ('생활', now(), now());
#
# insert into todo (title, content, done, cno, create_date, update_date) values('자바 공부', 'JPA 기본 개념 정리', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('Spring Boot 실습', 'REST API 만들기', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('React 공부', 'useState와 props 이해하기', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('데이터베이스 공부', 'JOIN과 INDEX 복습', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('알고리즘 문제풀이', '백준 문제 5개 풀기', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('헬스장 가기', '하체 운동', false, 2, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('러닝', '5km 달리기', false, 2, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('스트레칭', '아침 스트레칭 20분', true, 2, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('수영', '자유형 연습', false, 2, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('요가', '유연성 운동', false, 2, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('프로젝트 기획', '서비스 기능 목록 정리', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('회의 준비', '자료 PPT 작성', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('코드 리뷰', '팀원 PR 검토', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('API 설계', 'ERD 및 엔드포인트 설계', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('배포 준비', 'Docker 이미지 빌드', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('기타 연습', '기타 코드 연습', false, 4, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('독서', '기술 서적 30페이지 읽기', false, 4, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('사진 촬영', '야경 촬영 연습', false, 4, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('영화 감상', 'SF 영화 보기', true, 4, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('드로잉', '인물 스케치', false, 4, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('장보기', '마트에서 식료품 구매', false, 5, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('청소', '집 청소하기', false, 5, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('세탁', '세탁기 돌리기', true, 5, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('요리', '저녁 식사 준비', false, 5, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('공과금 납부', '전기세 납부', false, 5, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('AI 공부', '머신러닝 개념 정리', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('딥러닝 실습', 'CNN 모델 구현', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('LLM 실습', 'OpenAI API 테스트', false, 1, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('팀 프로젝트', '프론트엔드 UI 구현', false, 3, now(), now());
# insert into todo (title, content, done, cno, create_date, update_date) values('Git 정리', 'Git Flow 복습', false, 3, now(), now());

-- ----------------  Springweb sample insert ----------------
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user01', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '김민수', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user02', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이지은', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user03', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '박서준', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user04', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '최유리', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user05', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '정우성', now(), now());

INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user06', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '강하늘', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user07', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '한지민', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user08', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '신세경', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user09', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '김수현', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user10', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이종석', now(), now());

INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user11', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '박보검', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user12', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '송혜교', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user13', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '김태리', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user14', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '전지현', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user15', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '유재석', now(), now());

INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user16', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '강호동', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user17', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이광수', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user18', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '하정우', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user19', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '공유', now(), now());
INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user20', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '수지', now(), now());
