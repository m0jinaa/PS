# [Gold III] Meteor Shower - 6166 

[문제 링크](https://www.acmicpc.net/problem/6166) 

### 성능 요약

메모리: 29268 KB, 시간: 264 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2023년 11월 7일 16:17:14

### 문제 설명

<p>Bessie hears that an extraordinary meteor shower is coming; reports say that these meteors will crash into earth and destroy anything they hit. Anxious for her safety, she vows to find her way to a safe location (one that is never destroyed by a meteor) . She is currently grazing at the origin in the coordinate plane and wants to move to a new, safer location while avoiding being destroyed by meteors along her way.</p>

<p>The reports say that M meteors (1 <= M <= 50,000) will strike, with meteor i will striking point (X_i, Y_i) (0 <= X_i <= 300; 0 <= Y_i <= 300) at time T_i (0 <= T_i <= 1,000). Each meteor destroys the point that it strikes and also the four rectilinearly adjacent lattice points.</p>

<p>Bessie leaves the origin at time 0 and can travel in the first quadrant and parallel to the axes at the rate of one distance unit per second to any of the (often 4) adjacent rectilinear points that are not yet destroyed by a meteor.  She cannot be located on a point at any time greater than or equal to the time it is destroyed).</p>

<p>Determine the minimum time it takes Bessie to get to a safe place.</p>

### 입력 

 <ul>
	<li>Line 1: A single integer: M</li>
	<li>Lines 2..M+1: Line i+1 contains three space-separated integers: X_i, Y_i, and T_i</li>
</ul>

<p> </p>

### 출력 

 <ul>
	<li>Line 1: The minimum time it takes Bessie to get to a safe place or -1 if it is impossible.</li>
</ul>

<p> </p>

