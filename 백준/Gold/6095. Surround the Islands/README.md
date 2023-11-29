# [Gold IV] Surround the Islands - 6095 

[문제 링크](https://www.acmicpc.net/problem/6095) 

### 성능 요약

메모리: 34984 KB, 시간: 316 ms

### 분류

자료 구조, 분리 집합

### 제출 일자

2023년 11월 29일 21:22:24

### 문제 설명

<p>Farmer John has bought property in the Caribbean and is going to try to raise dairy cows on a big farm composed of islands. Set in his ways, he wants to surround all the islands with fence.</p>

<p>Each island in the farm has the shape of a polygon. He fences the islands one side at a time (between a consecutive pair of vertices) and proceeds clockwise around a given island with his fencing operations. Since he wants to fence all the islands, he must at some point travel to any other islands using a boat.</p>

<p>He can start fencing at any vertex and, at any vertex he encounters, travel to some vertex on another island, fence all the way around it, and then IMMEDIATELY return back to the same vertex on the original island using the same path he traveled before. Each boat trip has a cost defined by a supplied matrix.</p>

<p>The islands are described by a set of N (3 <= N <= 500) pairs of vertices V1,V2 (1 <= V1 <= N; 1 <= V2 <= N) although you must figure out how to assemble them into islands. The vertices are conveniently numbered 1..N.</p>

<p>The cost of traveling by boat between each pair of vertices is given by a symmetric cost matrix whose elements fall in the range 0..1000.</p>

<p>What is the minimum cost of surrounding the islands with the fence?</p>

### 입력 

 <ul>
	<li>Line 1: A single integer: N</li>
	<li>Lines 2..N+1: Each line describes an island's border with two space-separated integers: V1 and V2</li>
	<li>Lines N+2..2*N+1: Line i-N-1 contains N integers that describe row i of the cost matrix: Row_i</li>
</ul>

### 출력 

 <ul>
	<li>Line 1: A single integer that specifies the minimum cost of building the fence</li>
</ul>

<p> </p>

