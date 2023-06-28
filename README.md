# 프로젝트명: TestSelly #

프로젝트명이 셀리인 이유 : 테스트 리스트가 전부 몇개인지 하나하나 셀리 없잖아?

TestSelly를 사용하면 셀리 없고, Selly없는 사람들만 셀리 있겠죠?


## TestSelly 설명 ## 
### 기능 ###
1. 셀레니움 기본기능과 Selenide 고급 메소드 지원. TestNG를 사용한 테스트 코드 정리
2. 코드수정 일절없이 엑셀로 수정생성 가능한 간편한 사용방식
3. 비개발자, 운영자분들은 element를 입력하지 않아도 되는 정책
4. 클릭클릭클릭을 trim을 사용해서 문서작성을 간소화. (너무 남발하면 문서로 테스트 내용을 알 수 없음.)
5. WebDriver element 확인기능을 Deep하게! (Js.scrpitExcute와 While을 사용한 동적 확인)
6. 기존 탭 닫고, 새로운 탭에서 테스트 진행
7. 파일업로드 (mac지원, windows 지원 X)
8. 드래그 기능, 클릭, sendKey 메소드 사용중

### 당신이 원했을 수 도 있지만, 제공하지 않는 기능
1. Element 묵시적 대기 X, Element Trigger 하드코딩이 없기 때문에 Thread.sleep을 사용. A메소드에서 B메소드 호출 사이에 묵시적 대기(바인딩)가 걸리지 않음
2. 드롭박스 내부 element 확인기능. select + equals로 만들어서 사용하시면 됩니다.
3. 테스트 로그 수집기능 및 결과값 엑셀파일 생성기능

### 개발배경 ###
1. Collecter에서 수집한 데이터를 Node로 이동시키면서 데이터가 유실되는 케이스들을 발견
2. 모니터링 시스템에서 data flow를 확인하는 방법도 필요하지만, 클라우드 환경이 아닌 고객사 on-premise에서 사용할 수 있는 테스트기능도 필요했다.
3. 매일매일 변화하는 그래프, 히트맵, 히스토그램의 element 지표를 정책적으로? 기술적으로 확인하는 방법은 뭐가 있을까? 고민이 필요했다.
4. ~~프론트는 무조건 개별적인 ID를 부여하라~~ (배포테스트면 가능)

### 설치 ###
1. ChromeDriver 설치 (https://chromedriver.chromium.org/downloads)
<img width="957" alt="스크린샷 2023-06-27 오전 11 22 21" src="https://github.com/onycom-imqa/IMQA-TestSelly/assets/123140855/6f931ff0-5281-4ddc-8e00-aabdbb726427">

2. Aqua IDE 설치
(https://www.jetbrains.com/ko-kr/aqua/download/#section=mac)

셀레니움 프로젝트를 실행하기 위한 기본 라이브러리를 잘 제공해줌.


### Gradle ###

```
plugins {
    id 'java'
}

group 'com.example'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

sourceCompatibility = '18'
targetCompatibility = '18'

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

dependencies {

    implementation group: 'org.apache.poi', name: 'poi', version: '5.0.0'
    implementation group: 'org.apache.poi', name: 'poi-ooxml', version: '5.0.0'
		//엑셀파일 사용을 위한 라이브러리


    implementation('org.seleniumhq.selenium:selenium-java:4.7.0')
    testImplementation('org.seleniumhq.selenium:selenium-java:4.7.0')
		//셀레니움 사용을 위한 라이브러리

    testImplementation 'org.testng:testng:6.14.3'
		//테스트 코드의 재사용성을 높이기 위한 기능강화

    testImplementation 'junit:junit:4.13.2'

    implementation 'commons-io:commons-io:2.11.0'
    testImplementation 'com.codeborne:selenide:6.13.0'
		//셀레니움 고급 메소드를 사용하기 위한 셀레나이드

    implementation 'com.squareup.okhttp3:okhttp:4.9.1'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
}


test {
    useJUnit()
}
```


## 엑셀 파일의 테스트 정책 ##
시나리오 파일과 Matric 파일은 검증지표와 표시위치라는 기준을 공유합니다.
MatricList에는 Element가 저장됩니다.
시나리오 파일에서는 ActionName이 저장됩니다.

테스트의 전체적인 흐름은 Element에 Action을 지정하는 방식으로 진행됩니다.
파란색 셀이 지정된 시나리오파일구역을 키값으로 Element를 호출합니다. 아래의 그림을 보시면 더 쉽게 이해하실 수 있습니다.

### 시나리오 파일의 구조 ###
<img width="1245" alt="스크린샷 2023-06-27 오후 3 22 09" src="https://github.com/onycom-imqa/IMQA-TestSelly/assets/123140855/048df495-8897-43d2-a6d6-5032e6b296ba">


### Matric파일의 구조 ###
<img width="2243" alt="스크린샷 2023-06-27 오후 3 19 45" src="https://github.com/onycom-imqa/IMQA-TestSelly/assets/123140855/ab8de3bd-370c-4402-9c4a-dcb4674dc623">


