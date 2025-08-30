# [Gold III] Diana and the Golden Apples - 11079 

[문제 링크](https://www.acmicpc.net/problem/11079) 

### 성능 요약

메모리: 13488 KB, 시간: 160 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2025년 8월 30일 21:41:12

### 문제 설명

<p>The famously fleet-of-foot Roman huntress Diana has agreed to marry any man who can beat her or even equal her in a running race. A challenger, Prince Humperdonkey of Troy, is intending to beat her in a race by leaving golden apples along the track. He believes she will be tempted to pick them up, thereby slowing her down enough that he will be able to beat her. Little does he know that Diana, who has no wish to marry anyone at present (and certainly not the loathsome Humperdonkey) is an ICPC competitor who is perfectly able to compute exactly how many golden apples she can pick up while still winning the race. You are Diana and your job is to get as rich as possible while remaining single.</p>

### 입력 

 <p>The input contains a single test case.</p>

<p>The first line of input contains 5 space-separated integers: 1 ≤ L ≤ 1 000, the length of the race in units of 100 m; 10 ≤ Td, Th ≤ 30 the time in seconds that it takes Diana and Humperdonkey respectively to run 100 m; 0 ≤ N ≤ 1000 the number of golden apples Humperdonkey has placed on the race track; and 0 < d ≤ 10, the extra time in seconds that Diana takes to cover 100 m for each additional kilogram of gold that she is carrying.</p>

<p>This is followed by N lines, each with 2 space-separated integers 0 < wi ≤ 50, the weight of the ith apple in kg and 0 ≤ xi < L, the distance of the ith apple from the start of the track in units of 100 m.</p>

### 출력 

 <p>A single integer W ≥ 0, being the maximum weight in gold apples that Diana can be carrying when she crosses the finish line if she is to finish ahead of Prince Humperdonkey. If Diana is unable to beat Humperdonkey the output line should instead be</p>

<pre>Diana marries Humperdonkey</pre>

