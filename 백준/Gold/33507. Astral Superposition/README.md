# [Gold V] Astral Superposition - 33507 

[문제 링크](https://www.acmicpc.net/problem/33507) 

### 성능 요약

메모리: 102484 KB, 시간: 652 ms

### 분류

구현, 그리디 알고리즘, 시뮬레이션

### 제출 일자

2025년 9월 11일 23:27:37

### 문제 설명

<p>Bessie is using her nifty telescope to take photos of all the stars in the night sky. Her telescope can capture an $N \times N$ ($1 \leq N \leq 1000$) photo of the stars where each pixel is either a star or empty sky. Each star will be represented by exactly one pixel, and no two distinct stars share the same pixel.</p>

<p>Overnight, something strange happens to the stars in the sky. Every star either disappears or moves $A$ pixels to the right, and $B$ pixels downwards ($0 \leq A,B \leq N$). If a star disappears or moves beyond the photo boundary, it no longer appears in the second photo.</p>

<p>Bessie took photos before and after the shifting positions, but after experimenting in Mootoshop, she accidentally superimposed one photo onto the other. Now, she can see white pixels where both photos were empty, gray pixels where stars existed in exactly one photo, and black pixels where there was a star in both photos. Bessie also remembers that no new stars moved into the frame of the second photo, so her first photo contains all of the stars in the night sky.</p>

<p>Given the final photo, determine the minimum possible number of stars in the sky before the shifting incident for $T$ ($1 \leq T \leq 1000$) independent test cases. If no arrangement of stars can produce the given final photo, output $-1$.</p>

### 입력 

 <p>The first line of input contains $T$ and $T$ test cases will follow.</p>

<p>The first line of each test case will contain $N$ $A$ $B$.</p>

<p>Then follow $N$ lines each representing one row of the superimposed photo. The $i$th row from the top is represented by a string $c_{i,1}c_{i,2}\dots c_{i,N}$, where each $c_{i,j} \in \{W,G,B\}$, representing the colors white, gray, and black respectively.</p>

<p>It is guaranteed that the sum of $N^2$ over all test cases will not exceed $10^7$.</p>

### 출력 

 <p>For each test case, output the minimum number of stars that existed before the shifting, or $-1$ if impossible.</p>

