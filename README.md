| 기능    | Method | URL                   | request          | 상태코드    |
| ----- | ------ | --------------------- | -------------- | ------------ |
| 일정 생성 | POST   | `/calender` | 요청 body  | 200: 정상등록 |
| 선택 일정 조회 | GET    | `/calender/{id}` | 요청 param  | 200: 정상조회 |
| 일정 목록 조회 | GET    | `/calender`      | 요청 param | 200: 정상조회 |
| 일정 수정 | PUT    | `/calender/{id}` | 요청 body  | 200: 정상수정 |
| 일정 삭제 | DELETE | `/calender/{id}` | 요청 param     | 200: 정상삭제 |
