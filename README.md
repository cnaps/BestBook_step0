# BestBookMS

- 도메인 모델

![image](https://github.com/cnaps/BestBookMS/assets/15258916/1d4260a9-b866-466e-b1dd-e01f72152603)
- 프로젝트 생성
  - https://start.spring.io/
- 패키지 구조 생성
  - 핵사노널 or 레이어드
- 도메인 모델 개발
  - 엔티티,VO 생성
  - 도메인 모델 테스트
- 응용 서비스 개발
- 외부 영역 개발 
  - 인바운드 영역
    - REST API
    - DTO
  - 아웃바운드 영역
    - 레파지토리
    - OR 매핑 
- 도커 파일 생성
- 빌드
- 컨테이너 생성

- 카프카 컨테이너 생성
- 토픽 생성



- 도메인 모델과 구현 모델 차이
  - listBestBook은 BestBook의 책임이 아님
 
- 로컬에 몽고DB가 설치되어 있지 않고, 환경설정이 되지 않으면 빌드 에러 


- 몽고 DB 
  - 컨테이너로 생성
  ```
    docker run -d -p 27017:27017 --name mongodb mongo
  ```
 - GUI로 몽고 db관리 
   - MongoDB Compass
   - https://www.mongodb.com/try/download/atlascli

- 문제 해결
  - swagger-ui 가 보이지 않을 때
    - 스프링 부트 버전을 확인 할 것 : 2.7.4에서는 성공
    
