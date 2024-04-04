# D208 Sixth Sense

### - 개요

- 프로젝트명 (서비스명) : 성식당 (sungchef)

- 해결하고자 하는 문제 : 집밥 먹는 사람들이 증가 추세임. 그러나 집밥 요리는 두 가지 문제가 있음. 첫째, 오늘 뭐 먹지? 를 매일 고민해야 함. 둘째, 레시피 확인 후 요리하는 과정이 번거로움

- 달성하려는 목표 : 첫째, 맞춤형 메뉴 추천 둘째, 간편한 레시피 확인

- 진행 기간 : 2024.02.19 ~ 2024.04.05 (7주)

- 프로젝트 단계 & 시작일 & 종료일
  
  - 기획 - 시작일 2024.02.26 ~ 종료일 2024.03.05
  
  - 설계 - 시작일 2024.03.06 ~ 종료일 2024.03.11
  
  - 환경 구축 - 시작일 2024.03.13 ~ 종료일 2024.03.20
  
  - 개발 - 시작일 2024.03.18 ~ 종료일 (진행중)
  
  - 테스트 - (1차) 2024.03.22 , (2차) 2024.03.29

- 진행 인원 : 6명
  
  - Android : 안성준, 이우건, 조남현
  
  - Backend : 김성훈, 김효주, 양건우
  
  - BigData : 양건우
  
  - Infra : 김성훈, 김효주

- 주요 기능
  
  - 맞춤형 메뉴 추천
    
    - 유저 취향 - 취향 설문
    
    - 당신과 비슷한 유저들의 선택 - 비슷한 유저 로그
      
      - 비슷한 유저 판단 방법 = 유저 조리 레시피 로그 + 냉장고 재료 로그 + KNN 알고리즘, 코사인 유사도 알고리즘
    
    - 내 냉장고 재료 - 냉장고 재료 등록
      
      - 유저가 앱의 OCR 기능을 이용해 간편하게 장 본 품목 등록 가능
  
  - 간편한 레시피 확인
    
    - 간편한 레시피 듣기 & 넘기기
      
      - 레시피 읽어주기 (TTS) : ex. 스프가 끓으면 버섯을 넣는다.
      
      - 레시피 넘기기 (STT) ex. (유저가 버섯을 넣은 후) 다음

- 기대 효과
  
  - 외식비 지출 감소
  
  - 음식물 쓰레기 감소
  
  - 메뉴 고민 감소

- 기술 스택
  
  - Android
    
    - Hilt, MVVM, mockito
  
  - Backend
    
    - Spring boot, MSA, Kafka, hadoop
  
  - Infra
    
    - Docker compose, Docker, Redis, mariadb, ElasticSearch, Amazon S3, Amazon EC2, Jenkins

---

### Branch 전략 : Git Flow 간소화

| 출처 : [우린 Git-flow를 사용하고 있어요 | 우아한형제들 기술블로그]([우린 Git-flow를 사용하고 있어요 | 우아한형제들 기술블로그](https://techblog.woowahan.com/2553/))

- master : 제품으로 출시될 수 있는 브랜치

- develop/ad : 안드로이드 팀 내 협의 완료 브랜치

- develop/be : 백엔드 팀 내 협의 완료 브랜치

- feat/ad/** : 안드로이드 개발자 각자 기능 개발하는 브랜치

- feat/be/** : 백엔드 개발자 각자 기능 개발하는 브랜치

- 사용 방법
  
  1. develop 변경사항을 feat 으로 가져오기 (Optional)
  
  2- develop 브랜치에 upstream/feat-user 브랜치를 merge 합니다
  
  3- upstream/feat-user 기능이 merge된 develop를 upstream에 push 합니다
  
  4- 테스트 중 버그 수정하기
  
  5- 버그 수정
  
  6- 버그 수정 작업 브랜치를 origin 에 push 합니다

- 코드 리뷰
  
  - 툴 : Gerrit
  
  - 3, 6 단계에서 동료에게 코드 리뷰 받은 후 자신의 merge request 는 본인이 submit 합니다

---

## Git Convention

### 포맷

```git
type: subject 

body (optional)
```

#### type

- 하나의 커밋에 여러 타입이 존재하는 경우 상위 우선순위의 타입을 사용한다.
- fix: 버스 픽스
- feat: 새로운 기능 추가
- refactor: 리팩토링 (버그픽스나 기능추가없는 코드변화)
- docs: 문서만 변경
- style: 코드의 의미가 변경 안 되는 경우 (띄어쓰기, 포맷팅, 줄바꿈 등)
- test: 테스트코드 추가/수정
- chore: 빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우 (프로덕션 코드 변경 X)

#### subject

- 제목은 50글자를 넘지 않도록 한다.
- 개조식 구문 사용
  - 중요하고 핵심적인 요소만 간추려서 (항목별로 나열하듯이) 표현
- 마지막에 특수문자를 넣지 않는다. (마침표, 느낌표, 물음표 등)

#### body (optional)

- 각 라인별로 balled list로 표시한다.
  - 예시) - AA
- 가능하면 한줄당 72자를 넘지 않도록 한다.
- 본문의 양에 구애받지 않고 최대한 상세히 작성
- “어떻게” 보다는 “무엇을" “왜” 변경했는지 설명한다.

---

## Additional Requirement

각 MR의 요구사항과 더불어, 해당 명세를 **반드시** 만족해야 합니다.

- 매 Step 마다 테스트 코드를 작성해보세요.
- Code Convention 을 사용하여 코드를 작성해 주세요.
  - [**네이버 핵 데이 컨벤션**](https://naver.github.io/hackday-conventions-java/)을 사용합니다.