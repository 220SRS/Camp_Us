# Camping
- Camping 통합 예약 어플리케이션


## Docker Based Project 실행 방법
### 1. Docker-compose 실행
```
docker-compose -f docker-compose-local.yml up
```
### 2. 확인
```
docker ps
```

## 공공데이터 api 적용
- 최초 1회 실행
### 1. 데이터 로드
- request 보내기
```
GET localhost:8080/api/load-data
```