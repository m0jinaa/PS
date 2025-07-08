# [Gold II] LIFTOVI - 3229 

[문제 링크](https://www.acmicpc.net/problem/3229) 

### 성능 요약

메모리: 26096 KB, 시간: 292 ms

### 분류

데이크스트라, 그래프 이론, 최단 경로

### 제출 일자

2025년 7월 8일 15:57:39

### 문제 설명

<p>Solitaire has N elevators. Each elevator are connecting exactly two floors and it does not stop on the floors between that two floors. The speed of all the elevators are the same, 5 seconds to pass one floor.</p>

<p>On the beginning, each elevator is in its lower position and they are starting cruising to the upper floor. After some elevator come to its upper position, it immediatly starts to go back to its lower position, and so on...</p>

<p>Mirko is on the first (the lowest) floor and he wants as quick as possible come to the top of the solitaire. He can change elevators only on the floors that are common to both elevators, and if the other elevator is in that moment on that floor, that change does not take any time.</p>

<p>Write a program that will calculate minimal time in which Mirko can get to the top of the solitaire. </p>

### 입력 

 <p>In the first line of the input file there are two integers K and N, separated with space, number of floors <span style="line-height:1.6em">in solitaire and number of elevators, 2 ≤ K ≤ 1000, 1 ≤ N ≤ 50000.</span></p>

<p>In each of the next N lines there are description of one elevator, two integers A and B, separated with space, 1 ≤ A < B ≤ K, means that elevator is travelling between floors A and B. </p>

<p>There are no two different elevators that travels between same floors.</p>

<p>Note: input data will guarantee that solution will always exists. </p>

### 출력 

 <p>In the only line of output file write minimal time (in seconds) from the text above. </p>

