# SpringMall

Spring Boot와 Thymeleaf로 만든 간단한 상품 관리 웹 애플리케이션입니다.  
상품 등록, 조회, 수정, 삭제 흐름을 구현하며 Controller, Service, Repository 계층을 나누어 연습한 프로젝트입니다.

## 주요 기능

- 메인 페이지
- 상품 목록 조회
- 상품 등록
- 상품 상세 조회
- 상품 수정
- JavaScript `fetch`를 이용한 AJAX 방식 상품 삭제
- 공지사항 목록 조회
- 상품명, 가격 입력값 예외 처리

## 기술 스택

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Thymeleaf
- MySQL 8.0
- Gradle
- Lombok
- JavaScript Fetch API

## 프로젝트 구조

```text
src/main/java/com/smu88/shop
├── Controller
├── Entity
├── Repository
└── Service
```

- `Controller`: 요청 처리와 화면 반환
- `Service`: 비즈니스 로직, 입력값 검증, 데이터 처리
- `Repository`: JPA를 이용한 데이터 접근
- `Entity`: 상품과 공지사항 엔티티

## 실행 방법

### 1. MySQL 실행

Docker가 설치되어 있다면 아래 명령어로 MySQL을 실행할 수 있습니다.

```bash
docker compose up -d
```

`docker-compose.yml`에 설정된 기본 DB 정보는 다음과 같습니다.

```text
database: springdb
username: springuser
password: springpass
port: 3306
```

### 2. 애플리케이션 실행

```bash
./gradlew bootRun
```

실행 후 브라우저에서 아래 주소로 접속합니다.

```text
http://localhost:8080
```

## 주요 페이지

| 경로 | 설명 |
| --- | --- |
| `/` | 메인 페이지 |
| `/list` | 상품 목록 |
| `/write` | 상품 등록 |
| `/detail/{id}` | 상품 상세 |
| `/update/{id}` | 상품 수정 |
| `/notice` | 공지사항 |

## 입력값 검증

상품 등록 시 다음 조건을 검사합니다.

- 상품명이 비어 있으면 등록 불가
- 상품명이 20자를 초과하면 등록 불가
- 가격이 비어 있으면 등록 불가
- 가격이 숫자가 아니면 등록 불가
- 가격이 음수이면 등록 불가
- 가격이 100,000,000원을 초과하면 등록 불가

## 학습 내용

- Spring MVC의 Controller와 Thymeleaf 연동
- Model을 이용한 서버 데이터 전달
- Service 레이어 분리
- JPA Repository를 이용한 CRUD 처리
- `@PathVariable`을 이용한 상세/수정 페이지 구현
- JavaScript `fetch`와 `DELETE` 요청을 이용한 AJAX 삭제 처리
- 입력값 검증과 예외 메시지 출력
