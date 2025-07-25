# [Silver II] 테이블 옮기기 - 7348 

[문제 링크](https://www.acmicpc.net/problem/7348) 

### 성능 요약

메모리: 12220 KB, 시간: 76 ms

### 분류

구현, 그리디 알고리즘, 누적 합

### 제출 일자

2025년 7월 14일 19:03:14

### 문제 설명

<p>ACM 회사는 아래 그림과 같은 빌딩의 한 층을 빌렸다. 이 층의 방들은 다음과 같이 번호가 매겨져 있다.</p>

<p><img alt="movingtable.png" src="https://upload.acmicpc.net/13c78610-a087-45db-b9b9-d158f9015ea9/-/preview/"></p>

<p>그림처럼 이 층에는 복도를 따라 양쪽 사이드로 각각 200개의 방이 있다. ACM 회사는 이 방들을 리모델링하려는 계획을 세웠다. 당연히 어떤 방에서 다른 방으로 많은 테이블을 옮겨야 한다. 이때 복도는 좁고 테이블이 커서 단지 하나의 테이블만 이 복도를 지날 수 있다.</p>

<p>방에서 다른 방으로 테이블을 옮기는 데 소요되는 시간은 10분 이다. i 번째 방에서 j 번째 방으로 테이블을 옮길 때 i번 방 앞의 복도부터 j번 방 앞의 복도까지가 사용된다. 매 10분 동안 복도가 중첩되어 사용되지 않는다면 여러개의 작업을 동시에 할 수 있다.</p>

<p>예를 들어 30번 방에서 50번 방으로 옮기는 작업과, 60번 방에서 90번 방으로 옮기는 작업은 중첩되는 복도가 없으므로 동시에 할 수 있다. 11번 방에서 12번 방으로 옮기는 작업과, 14번 방에서 13번 방으로 옮기는 작업 역시 중첩되는 복도가 없으므로 동시에 가능하다.</p>

<p>하지만 20번 방에서 40번 방으로 옮기는 작업과, 31번 방에서 80번으로 옮기는 작업은, 31번 방 앞 복도부터 40번 방 앞 복도까지의 공간이 중첩되므로 동시에 작업하기엔 무리가 있다. 마찬가지로 1번 방에서 4번 방으로 옮기는 작업과, 3번 방에서 6번 방으로 옮기는 작업 역시 3번 방 앞 복도를 작업 공간으로 공유하므로 동시에 작업하기엔 무리가 있다.</p>

<p>각 방에서 많아야 하나의 테이블이 들어가거나 나갈 것이다. 모든 테이블을 옮기는 데 필요한 최소 시간을 구하는 프로그램을 작성하시오</p>

### 입력 

 <p>첫 줄에 테스트 케이스의 개수 T가 주어진다.</p>

<p>각 테스트 케이스마다, 첫 수는 이동 수 N ( 1 <= N <= 200 ) 이다. 다음 줄 N 줄은 각 각 두개의 양의 정수 s,t 가 입력으로 주어진다. s 방에서 t 방으로 의 이동을 의미한다. 방 번호는 많아야 한 번 입력데이터에 주어진다.</p>

### 출력 

 <p>각 테스트 케이스마다, 첫 줄에 책상을 옮기는 작업을 마치는 데 필요한 최소 작업 시간을 출력한다.</p>

