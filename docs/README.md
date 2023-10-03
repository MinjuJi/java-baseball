## 기능 목록

:file_folder: Domain
  - Computer
      - getComputerGameNumbers
        - 상대방(컴퓨터) 숫자 리스트 반환
      - setupGameNumbers
        - 상대방 숫자 생성 및 저장
  - User
      - getUserGameNumbers
        - 사용자 숫자 리스트 반환
      - getUserGameNumbers
        - 사용자 숫자 저장

:file_folder: Exception
  - InputNumbersException
    - checkValidOfUserInput
      - 사용자가 입력한 숫자의 예외를 종합하여 검토해주는 기능
    - isNumberSizeEqualsThree
      - 3개의 숫자를 입력했는지 확인해주는 기능
    - isContainedOnlyNumber
      - 숫자만 입력했는지 확인해주는 기능
    - isOverlapNumber
      - 중복된 수가 아닌지 확인해주는 기능
  - AfterGamePlayException
    - askAfterResultException
      - 게임 종료 후 입력하는 숫자에 관해 예외를 종합하여 검토해주는 기능
    - isRightLength
      - 1개의 숫자를 입력했는지 확인해주는 기능
    - isRightNumber
      - 1 또는 2를 입력했는지 확인해주는 기능

:file_folder: Util
  - StringNumToIntegerNumListParser
    - stringNumToIntegerNumListParser
      - 문자열로 들어오는 숫자를 List<Integer> 타입으로 파싱해주는 기능
  - GenerateComputerGameNumber
    - generateComputerGameNumber
      - 컴퓨터의 랜덤 넘버를 생성해주는 기능
      
:file_folder: View
  - UserInputView
    - setUserGameNumbers
      - 사용자의 숫자 입력과 관련한 메소드 묶음
    - printQuestion
      - "숫자를 입력해주세요" 안내 메시지 출력
    - getUserInput
      - 문자열 타입의 숫자 입력 기능
    - checkUserInputException
      - 입력한 숫자 예외 검사
    - toIntegerList
      - 입력한 숫자 파싱
  - GameResultView
    - printNotThreeStrikeResult
      - 정답이 아닌 경우 문구 출력
    - printThreeStrikeResult
      - 정답을 맞출 경우 문구 출력
    - printCreateController
      - 야구 게임 시작 시 문구 출력
  - NextGameUserInputView
    - askNextGame
      - 게임 종료 후 다음 게임을 위해 유저가 입력하는 값을 받고 예외를 검사하는 기능

:file_folder: Service
  - GameNumberCalculatorService
    - calculateGameNumber
      - 숫자야구 계산 관련 메소드 묶음
    - setStrikeAndBallCountList
      - 스트라이크와 볼 개수를 List<Integer>에 순서대로 추가하는 기능
    - getStrikeCount
      - 스트라이크 개수 반환
    - countStrike
      - 스트라이크 개수 계산
    - isStrike
      - 스트라이크인지 검사하는 기능
    - getBallCount
      - 볼 개수 반환
    - countBall
      - 볼 개수 계산
    - resetCalculator
      - 스트라이크와 볼 개수를 초기화 하는 기능
  - GameStatusService
    - isExitGame
      - 게임종료 여부 true/false 반환
    - processNextGameStatus
      - setNextGameStatus 메소드 실행
    - setNextGameStatus
      - 사용자가 정답을 맞춘 후 입력한 숫자에 따라 게임 상태 변경
    
:file_folder: Controller
  - GamePlayController
    - GamePlayController
      - 게임 시작 문구 출력
    - startGame
      - 게임 진행과 관련한 메소드 모음
    - inputUserNumber
      - 사용자 숫자 입력 및 저장 기능
    - calculateStrikeAndBallCount
      - 숫자야구 계산
    - getGameResult
      - 게임 결과 반환