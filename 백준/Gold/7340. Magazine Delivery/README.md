# [Gold IV] Magazine Delivery - 7340 

[문제 링크](https://www.acmicpc.net/problem/7340) 

### 성능 요약

메모리: 16980 KB, 시간: 108 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 6월 3일 18:32:33

### 문제 설명

<p>The TTT Taxi Service in Tehran is required to deliver some magazines to N locations in Tehran. The locations are labeled L<sub>1</sub> to L<sub>N</sub>. TTT assigns 3 cars for this service. At time 0, all the 3 cars and magazines are located at L1. There are plenty of magazines available in L<sub>1</sub> and the cars can take as many as they want. Copies of the magazine should be delivered to all locations, observing the following rules:</p>

<p>For all i = 2 .. N, magazines should be delivered at Li only after magazines are delivered at L<sub>i –1</sub> .<br>
At any time, only one of the three cars is driving, and the other two are resting in other locations.</p>

<p>The time to go from L<sub>i</sub> to L<sub>j</sub> (or reverse) by any car is a positive integer denoted by D[i , j].</p>

<p>The goal is to organize the delivery schedule for the cars such that the time by which magazines are delivered to all N locations is minimum.</p>

<p>Write a program to compute the minimum delivery time.</p>

### 입력 

 <p>The input file contains M instances of this problem (1 ≤ M ≤ 10). The first line of the input file is M. The descriptions of the input data follows one after the other. Each instance starts with N in a single line (N ≤ 30). Each line i of the following N-1 lines contains D[i , j], for all i=1..N-1, and j=i+1..N.</p>

### 출력 

 <p>The output file contains M lines, each corresponding the solution to one of the input data. In each line, the minimum time it takes to deliver the magazines to all N locations is written.</p>

