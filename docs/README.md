# 기능 구현 목록

---

## :file_folder: domain

- Computer
    - 상대편(컴퓨터) 숫자 생성 및 저장
- User
    - 사용자 숫자 생성 및 저장

## :file_folder: service

- GameNumberCalculatorService
    - 상대편과 사용자의 숫자를 비교하여 볼 개수 카운트
    - 상대편과 사용자의 숫자를 비교하여 스트라이크 개수 카운트
    - 스트라이크와 볼 개수 리스트에 저장
    - 스트라이크와 볼 개수 리스트 초기화
- GameStatusService
    - 다음 게임 상태를 관리

## :file_folder: view

- GameStartView
    - 게임 시작 화면
- InputNumbersView
    - 숫자 입력 화면
- GameResultView
    - 상대편과 사용자의 숫자 비교 결과 화면
- SelectNextGame
    - 다음 게임 상태 선택 화면

## :file_folder: controller

- GamePlayController
    - 전체적인 게임 진행 담당

## :file_folder: exception

- inputNumberException
    - 사용자 입력 값이 유효한 길이인지 검사
    - 사용사 입력 값이 숫자로만 이루어졌는지 검사
    - 사용자 입력 값이 중복값이 있는지 검사

- NextGamePlayException
    - 게임종료 후 입력 값이 유효한 길이인지 검사
    - 게임종료 후 입력 값이 1 또는 2인지 검사

## :file_folder: util

- GenerateComputerGameNumber
    - 상대편 숫자 리스트 생성
- ParseIntegerList
    - 사용자가 입력한 문자열 타입의 숫자를 정수타입으로 변환 및 분해하여 List에 담아 반환
- ParseIntegerSet
    - 사용자가 입력한 문자열 타입의 숫자를 정수타입으로 변환 및 분해하여 Set에 담아 반환
