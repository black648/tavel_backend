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

2. 테스트진행
  * 단순기능 테스트
    - 도시 : CityServiceTest
    - 여행 : TravelServiceTest
      - 여행 도시 : TravelCityServiceTest
      - 여행 계획 : TravelPlanServiceTest
  * 기능단위 테스트
    - 도시 : CityServiceTest
     1) 사용자 별 도시 조회 (데이터 세팅 후 select 수행): selectCityBeforeSetData
    - 여행 : TravelServiceTest
     1) 여행등록, 여행계획등록, 여행도시등록 : saveTravel_TravelPlan_City_TravelCity
     2) 여행, 여행계획 등록 후 여행계획 편집까지 수행 : updateTravelPlan
     3) 등록한 여행에 대한 여행계획 등록 후 일정 변경 : updateTravel_TravelPlan_TravelCity
     4) 등록한 여행에 도시정보를 추가 : createTravel_createTravelCity_updateTravelCity
     5) 여행, 여행계획, 여행도시 등록 후 삭제 : createTravel_delete
     6) 단일 여행 + 여행계획 조회 : get