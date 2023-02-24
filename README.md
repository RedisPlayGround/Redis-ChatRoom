# Redis-ChatRoom

## Pub/Sub 패턴

- 메시징 모델 중의 하나로 발행(Publish)과 구독(Subscribe) 역할로 개념화 한 형태
- 발행자와 구독자는 서로에 대한 정보 없이 특정 주제(토픽 or 채널)를 매개로 송수신

![image](https://user-images.githubusercontent.com/40031858/221067498-f4636cc9-31ce-4451-9416-6555a0f08459.png)


### 메시징 미들웨어 사용의 장점

- 비동기 : 통신의 비동기 처리
- 낮은 결합도: 송신자와 수신자가 직접 서로 의존하지 않고 공통 미들웨어에 의존
- 탄력성: 구성원들간에 느슨한 연결로 인해 일부 장애가 생겨도 영향이 최소화됨

ex) Kafka, RabbitMQ, ActiveMQ, ...

## Redis의 Pub/Sub 특징

- 메시지가 큐에 저장되지 않음
- Kafka의 컨슈머 그룹같은 분산처리 개념이 없음
- 메시지 발행 시 push 방식으로 subscriber들에게 전송
- subscriber가 늘어날수록 성능이 저하

 ![image](https://user-images.githubusercontent.com/40031858/221068157-ac09f2a6-7491-4fa0-b7ba-5c735df0d325.png)


### Redis의 Pub/Sub의 유즈케이스

- 실시간으로 빠르게 전송되어야 하는 메시지
- 메시지 유실을 감내할 수 있는 케이스
- 최대 1회 전송(at-most-once) 패턴이 적합한 경우
- Subscriber들이 다양한 채널을 유동적으로 바꾸면서 한시적으로 구독하는 경우

