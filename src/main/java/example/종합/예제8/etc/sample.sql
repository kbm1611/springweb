# [1] 데이터베이스 생성(데이터 설계에 따른)
drop database if exists boardservice7;
create database boardservice7;
use boardservice7;

# [2] 테이블 생성
create table board(
	bno int auto_increment,
    bcontent longtext not null,
    bwriter varchar(30) not null,
    bdate datetime default now(),
    constraint primary key(bno)
);

# [3] 테이블 샘플 데이터
INSERT INTO board (bcontent, bwriter, bdate) VALUES
('안녕하세요, 첫 번째 게시글입니다!', 'admin', '2024-01-01 10:00:00'),
('자바 알고리즘 공부 중인데 어렵네요 ㅠㅠ', 'java_lover', '2024-01-01 11:30:20'),
('오늘 점심 메뉴 추천받습니다.', 'hungry_man', '2024-01-02 12:05:11'),
('데이터베이스 설계할 때 주의할 점이 뭐가 있을까요?', 'db_newbie', '2024-01-02 14:20:00'),
('SQL 인서트 문 작성하는 법 공유합니다.', 'sql_master', '2024-01-03 09:15:45'),
('반갑습니다. 새로 가입했어요!', 'hello_world', '2024-01-03 15:40:12'),
('Spring Boot와 MySQL 연동 질문 있습니다.', 'spring_dev', '2024-01-04 10:10:05'),
('코딩 테스트 준비는 역시 꾸준함이 답인 것 같아요.', 'algorithm_god', '2024-01-04 18:22:30'),
('날씨가 갑자기 추워졌네요. 다들 감기 조심하세요!', 'weather_bot', '2024-01-05 08:00:00'),
('이 게시판 디자인이 깔끔하고 좋네요.', 'ui_designer', '2024-01-05 13:45:18'),
('프로그래밍 언어 추천 부탁드립니다.', 'beginner', '2024-01-06 11:00:55'),
('Git Commit 메시지 규칙 어떻게 정하시나요?', 'git_user', '2024-01-06 16:30:22'),
('퇴근하고 싶다... 월요병이 도졌나 봐요.', 'office_worker', '2024-01-07 14:10:00'),
('객체 지향 프로그래밍의 4대 특징 정리!', 'study_hard', '2024-01-07 20:15:33'),
('페이징 처리를 구현하려는데 잘 안 되네요.', 'page_dev', '2024-01-08 10:05:44'),
('혹시 맥북 에어랑 프로 중에 뭐가 더 개발하기 좋나요?', 'apple_fan', '2024-01-08 15:50:11'),
('Docker 컨테이너 설정 도와주실 분?', 'infra_man', '2024-01-09 09:12:00'),
('오늘 드디어 프로젝트 마감했습니다! 만세!', 'tired_coder', '2024-01-09 23:45:10'),
('자바스크립트 프레임워크 순위가 궁금해요.', 'js_king', '2024-01-10 11:20:05'),
('마지막 20번째 게시글 샘플입니다.', 'sample_user', '2024-01-10 17:00:00');
select * from board;