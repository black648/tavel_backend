# 환경설정
1. DB
   * mysql 설치
     - brew install mysql
     
   * Mysql 
     - 초기 관리자 계정 설정
       set password for 'root'@'localhost' = password('변경할 비밀번호');
     - DB 생성
       CREATE DATABASE travel CHARACTER SET='utf8' COLLATE='utf8_bin';
     - 사용자 생성
       CREATE USER travel IDENTIFIED BY 'travel';
     - 로컬 DB접근 허용
       GRANT ALL PRIVILEGES on ecm.* to 'travel’@‘localhost’ identified by 'travel';