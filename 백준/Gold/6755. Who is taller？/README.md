# [Gold V] Who is taller? - 6755 

[문제 링크](https://www.acmicpc.net/problem/6755) 

### 성능 요약

메모리: 278404 KB, 시간: 808 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 6월 12일 14:38:29

### 문제 설명

<p>You have a few minutes before your class starts, and you decide to compare the heights of your classmates. You don’t have an accurate measuring device, so you just compare relative heights between two people: you stand two people back-to-back, and determine which one of the two is taller. Conveniently, none of your classmates are the same height, and you always compare correctly (i.e., you never make a mistake in your comparisons).</p>

<p>After you have done all of your comparisons, you would like to determine who the tallest person is between two particular classmates.</p>

### 입력 

 <p>The first line contains two integers N and M separated by one space. N, the number of people in the class, is an integer with 1 ≤ N ≤ 1000000. M, the number of comparisons that have already been done, is an integer with 1 ≤ M ≤ 10000000. Each of the next M lines contains two distinct integers x and y (1 ≤ x, y ≤ N) separated by a space, indicating that person number x was determined to be taller than person number y. Finally, the last line contains two distinct integers p and q (1 ≤ p, q ≤ N) separated by one space: your goal is to determine, if possible, whether person p is taller than person q. Note that it may be the case that neither p nor q occur in the input concerning measurements between classmates, and each measurement between any two particular people will be recorded exactly once.</p>

### 출력 

 <p>The output is one line, containing one of three possible strings:</p>

<ul>
	<li>yes (if p is taller than q),</li>
	<li>no (if q is taller than p),</li>
	<li>unknown (if there is not enough information to determine the relative heights of p and q).</li>
</ul>

