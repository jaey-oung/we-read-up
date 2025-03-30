# 📚 We Read Up

## 🚀 프로젝트 개요

**We Read Up**은 사용자들이 온라인에서 책을 검색하고, 구매하며, 리뷰를 남길 수 있는 웹 애플리케이션입니다.  
Java Spring을 기반으로 MyBatis를 활용하여 개발되었습니다.

---

## 🛠 개발 환경

- **언어:** Java (JDK 21)  
- **프레임워크:** Spring (Spring Boot, Spring MVC, Spring JDBC)  
- **빌드 도구:** Gradle  
- **데이터베이스:** MySQL  
- **ORM:** MyBatis  
- **서버:** Tomcat  
- **IDE:** IntelliJ  

---

## 🔧 프로젝트 설정

### 1️⃣ 데이터베이스 설정

`application.properties` 파일에서 데이터베이스 설정을 확인하고 환경에 맞게 변경하세요.

```properties
spring.application.name=we-read-up

spring.datasource.url=jdbc:mysql://localhost:3306/book_store?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.type-aliases-package=java.lang, com.wru.wrubookstore.dto, com.wru.wrubookstore.domain
```

---

### 2️⃣ 프로젝트 실행 방법

#### 🏁 MySQL 데이터베이스 실행

- `book_store` 데이터베이스를 생성하고,
- `application.properties`에 맞게 사용자 정보를 설정합니다.

#### 🚀 프로젝트 빌드 및 실행

- IntelliJ에서 Tomcat을 설정하여 직접 실행할 수 있습니다.

---

## 📌 API 명세서

### 🏠 HomeController

| 기능 | 요청 방식 | URI | 요청 파라미터 | 반환 데이터 | 응답 화면 |
|------|-----------|-----|----------------|--------------|-------------|
| 메인 홈 화면 표시 | GET | `/` | - | `List<RankedBookDto> rankedBooks` | `home.html` |

---

### 📦 AddressController

| 기능 | 요청 방식 | URI | 요청 파라미터 | 반환 데이터 | 응답 화면 |
|------|-----------|-----|----------------|--------------|-------------|
| 배송지 목록 조회 | GET | `/myPage/addressList` | `@SessionAttribute Integer userId` | `List<AddressDto> addressList` | `myPage/address-list.html` |
| 배송지 추가 | POST | `/myPage/addAddress` | `@Valid @ModelAttribute AddressDto addressDto` | 성공: 리디렉트 | `myPage/add-address.html` |

---

### 📚 BookController

| 기능 | 요청 방식 | URI | 요청 파라미터 | 반환 데이터 | 응답 화면 |
|------|-----------|-----|----------------|--------------|-------------|
| 카테고리별 상품 조회 | GET | `/bookList` | `MainSearchCondition sc` | `List<BookDto> list` | `book/book-list.html` |
| 상품 상세 페이지 이동 | GET | `/bookDetail` | `Integer bookId` | `BookDto bookDto` | `book/book-detail.html` |

---

### 🛒 CartController

| 기능 | 요청 방식 | URI | 요청 파라미터 | 반환 데이터 | 응답 화면 |
|------|-----------|-----|----------------|--------------|-------------|
| 장바구니 조회 | GET | `/cart/list` | `@SessionAttribute Integer userId` | `List<CartListResponse> list` | `myPage/cart-list.html` |
| 장바구니 추가 | POST | `/cart/add/one` | `@RequestBody CartDto cartDto` | 성공: `"장바구니에 추가되었습니다"` | - |

---

### 🔑 LoginController

| 기능 | 요청 방식 | URI | 요청 파라미터 | 반환 데이터 | 응답 화면 |
|------|-----------|-----|----------------|--------------|-------------|
| 로그인 처리 | POST | `/login/login` | `String email`, `String password` | 성공: 리디렉트 | `login/login.html` |
| 로그아웃 | GET | `/login/logout` | `HttpSession session` | - | 리디렉트 |

---

## 🏗 프로젝트 구조

```
we-read-up/
├── 📂 src/main/java/com/wru/wrubookstore/
│   ├── 📂 controller/     # 컨트롤러 클래스
│   ├── 📂 domain/         # 도메인 모델 클래스
│   ├── 📂 dto/            # DTO 클래스
│   ├── 📂 error/          # 에러 클래스
│   ├── 📂 service/        # 서비스 클래스
│   ├── 📂 repository/     # 데이터 액세스 클래스
├── 📂 src/main/resources/
│   ├── 📂 mapper/         # MyBatis XML 매퍼 파일
│   ├── 🎨 static/         # 정적 리소스 (CSS, JS, 이미지)
│   ├── 🏗 templates/      # HTML 템플릿 파일
│   └── ⚙ application.properties
└── ⚙ build.gradle         # Gradle 의존성 관리
```
