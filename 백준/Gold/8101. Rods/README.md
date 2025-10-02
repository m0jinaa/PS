# [Gold II] Rods - 8101 

[문제 링크](https://www.acmicpc.net/problem/8101) 

### 성능 요약

메모리: 22660 KB, 시간: 196 ms

### 분류

이분 탐색, 기하학, 수학

### 제출 일자

2025년 10월 2일 15:23:14

### 문제 설명

<p>In laboratories of a certain company a new material called politoksyparen is tested. During the researches an interesting property has been discovered. A simple rod made of this material after being heated lengthens and bends so that it changes into an circular arc based on a chord, which is the shape of the rod at the beginning (this property concerns only rods of short diameters). Let's assume that n rods with very short diameters and lengths l<sub>i</sub> (1 ≤ l<sub>i</sub> ≤ 100,000) were used to verify this property, and while being heated they lengthened respectively by d<sub>i</sub> (1 ≤ d<sub>i</sub> ≤ 100), where d<sub>i</sub> ≤ l<sub>i</sub>/2. As a unit we take one millimeter.</p>

<p>Write a program that:</p>

<ul>
	<li>reads from the standard input a number of rods n, their lengths l<sub>i</sub> and increases in lengths d<sub>i</sub>,</li>
	<li>computes for each rod a distance between the middle of the chord and the middle of the arc after heating (assuming that politoksyparen has indeed the observed property, and rods really band into circular arcs while being heated); the result should be an integer which differs no more then 0.5 from the exact result,</li>
	<li>writes the solution to the standard output.</li>
</ul>

### 입력 

 <p>In the first line of the standard input there is written one positive integer n (n ≤ 50,000). In each of the following n lines there are written two integers separated by a single space — the original length of the rod l<sub>i</sub> and its increase in length during heating d<sub>i</sub>.</p>

### 출력 

 <p>In each of n lines of the standard output there should be written one nonnegative integer. The integer in i-th line should be equal to the distance between the positions of the middle of the i-th rod before and after heating computed with a required accuracy.</p>

