# [Gold V] Connectedness - 32665 

[문제 링크](https://www.acmicpc.net/problem/32665) 

### 성능 요약

메모리: 251644 KB, 시간: 840 ms

### 분류

자료 구조, 분리 집합

### 제출 일자

2025년 8월 11일 14:43:02

### 문제 설명

<p>You are given an undirected graph $G=(V,E)$.</p>

<p>If you are drawing in the edges one by one, how many edges did you add when the graph becomes connected for the first time.</p>

<p>If the graph never becomes connected after drawing all the edges, output <code>-1</code>.</p>

<p>Here are some useful definitions:</p>

<ul>
	<li>A graph is connected if between any two vertices $u,v \in V$, you can reach $u$ from $v$ along a path of edges.</li>
	<li>A graph is undirected if every edge from a vertex $u$ to a vertex $v$ allows travel from vertex $v$ to vertex $u$ as well.</li>
</ul>

### 입력 

 <p>The input line of input contains two space-separated integers $N$ $(1 \leq N \leq 10^6)$ and $M$ $(0 \leq M \leq \min(10^6, \binom{N}{2}))$, the number of vertices and edges in the graph.</p>

<p>Each of the remaining $M$ lines contains two space-separated integers $u_i$ and $v_i$ $(1 \leq u_i, v_i \leq N)$, denoting an undirected edge from node $u_i$ to node $v_i$. No edge connects a node to itself, and there is at most one edge between any pair of nodes.</p>

### 출력 

 <p>Print either the number of edges that you added the first time graph becomes connected and <code>-1</code> otherwise.</p>

