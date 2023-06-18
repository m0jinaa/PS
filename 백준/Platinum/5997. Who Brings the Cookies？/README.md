# [Platinum III] Who Brings the Cookies? - 5997 

[문제 링크](https://www.acmicpc.net/problem/5997) 

### 성능 요약

메모리: 11988 KB, 시간: 92 ms

### 분류

이분 매칭, 최대 유량

### 문제 설명

<p>Farmer John's N (1 <= N <= 1,000) cows conveniently numbered 1..N decided to form M (1 <= M <= 100) study groups. A total of S_i (1 <= S_i <= 19) cows study in group G_i (namely cows G_i1, G_i2, ...). A cow might study in more than one study group.</p>

<p>For each study group, one cow in the group must be chosen to bring cookies to the meeting. Cookies are costly and require time to acquire, so the cows want to divide the work of bringing cookies as fairly as possible.</p>

<p>They decided that if a cow attends meetings with size c_1, c_2, ..., c_K, she is only willing to bring cookies to at most ceil(1/c_1 + 1/c_2 + ... + 1/c_K) meetings.</p>

<p>Figure out which cow brings cookies to each meeting. If this isn't possible, just output "-1". Choose any solution if more than one is possible.</p>

### 입력 

 <ul>
	<li>Line 1: Two space-separated integers: N and M</li>
	<li>Lines 2..M+1: Line i+1 contains many space-separated integers: S_i, G_i1, G_i2, ...</li>
</ul>

<p> </p>

### 출력 

 <ul>
	<li>Lines 1..M: If a mapping is possible, line i contains the number of the cow who brings cookies to study group i. Otherwise, line 1 contains just the integer -1.</li>
</ul>

