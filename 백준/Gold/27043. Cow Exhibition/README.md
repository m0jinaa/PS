# [Gold III] Cow Exhibition - 27043 

[문제 링크](https://www.acmicpc.net/problem/27043) 

### 성능 요약

메모리: 13464 KB, 시간: 144 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2023년 10월 10일 17:03:50

### 문제 설명

<p>"Fat and docile, big and dumb, they look so stupid, they aren't much fun..."</p>

<p>- Cows with Guns by Dana Lyons</p>

<p>The cows want to prove to the public that they are both smart and fun. In order to do this, Bessie has organized an exhibition that will be put on by the cows. She has given each of the N (1 ≤ N ≤ 100) cows a thorough interview and determined two values for each cow: the smartness Si (-1000 ≤ Si ≤ 1000) of the cow and the funness Fi (-1000 ≤ Fi ≤ 1000) of the cow.</p>

<p>Bessie must choose which cows she wants to bring to her exhibition. She believes that the total smartness TS of the group is the sum of the Si's and, likewise, the total funness TF of the group is the sum of the Fi's. Bessie wants to maximize the sum of TS and TF, but she also wants both of these values to be non-negative (since she must also show that the cows are well-rounded; a negative TS or TF would ruin this).  Help Bessie maximize the sum of TS and TF without letting either of these values become negative.</p>

### 입력 

 <ul>
	<li>Line 1: A single integer N, the number of cows</li>
	<li>Lines 2..N+1: Two space-separated integers Si and Fi, respectively the smartness and  funness for each cow.</li>
</ul>

### 출력 

 <ul>
	<li>Line 1: One integer: the optimal sum of TS and TF such that both TS and TF are  non-negative.  If no subset of the cows has non-negative TS and non- negative TF, print 0.</li>
</ul>

